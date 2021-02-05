import scala.collection.mutable.HashMap
import scala.collection.immutable.Set
import scala.collection.mutable.Queue

object Solution {
  def findLadders(
      start: String,
      end: String,
      wordList: List[String]
  ): List[List[String]] = {
    val visited = HashMap[String, Int]((start -> 0)) // visited w/ distance
    val q = Queue[String](start) // put the first word in q
    val adjMap = createAdjMap(q, visited, HashMap(), wordList.toSet, end)
    findPaths(List(start), 1, end, visited, adjMap).map(_.reverse)
  }

  private def createAdjMap(
      q: Queue[String],
      visited: HashMap[String, Int],
      adjMap: HashMap[String, List[String]],
      wordSet: Set[String],
      end: String
  ): HashMap[String, List[String]] = {
    if (q.isEmpty) return adjMap
    if (q.contains(end)) return adjMap
    val list = q.dequeueAll(_ => true) // get all items for current level
    val level = visited(list.head)
    val neighbors: Seq[String] =
      list.flatMap(cWord =>
        adjMap.getOrElseUpdate(cWord, getNeighbors(cWord, wordSet))
      )
    neighbors
      .filterNot(visited.contains)
      .foreach(neighbor => {
        visited(neighbor) = level + 1
        q.enqueue(neighbor)
      })
    createAdjMap(q, visited, adjMap, wordSet, end)
  }

  private def getNeighbors(
      cWord: String,
      wordSet: Set[String]
  ): List[String] = {
    (for {
      i <- 0 until cWord.length()
      c <- 'a' to 'z'
      if (cWord(i) != c)
    } yield {
      Some(cWord.updated(i, c)).filter(wordSet.contains)
    }).flatten.toList
  }

  private def findPaths(
      cPath: List[String],
      cLevel: Int,
      end: String,
      visited: HashMap[String, Int],
      adjMap: HashMap[String, List[String]]
  ): List[List[String]] = {
    if (cPath.isEmpty) return Nil
    if (cPath.head == end) return List(cPath)
    val neighbors = adjMap
      .getOrElse(cPath.head, return Nil)
      .filter(visited.getOrElse(_, -1) == cLevel)

    neighbors.flatMap(neighbor =>
      findPaths(neighbor :: cPath, cLevel + 1, end, visited, adjMap)
    )
  }
}

/*
G: beginWord: String, endWord: String, wordList: List[String]
O: allShortestTransformSeq: List[List[String]]
T: O(NM), N is number of words in list, m is number of letters
S: O(N)

Notes:
  - Only one letter can be changed at a time
  - Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
  - Return an empty list if there is no such transformation sequence.
  - All words have the same length.
  - All words contain only lowercase alphabetic characters.
  - You may assume no duplicates in the word list.
  - You may assume beginWord and endWord are non-empty and are not the same.

Ex:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
 */
