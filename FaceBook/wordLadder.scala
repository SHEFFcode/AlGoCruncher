import scala.collection.mutable
object Solution {
  val NO_PATHS_POSSIBLE = 0
  def ladderLength(
      beginWord: String,
      endWord: String,
      wordList: List[String]
  ): Int = {
    val len = beginWord.length // since all words are of the same length

    val wordsAdjToVariant =
      wordList.foldLeft(mutable.HashMap[String, mutable.ListBuffer[String]]()) {
        case (w2Variant, word) => {
          for (i <- 0 until len) {
            val variant = getVariant(i, word, len)
            w2Variant(variant) = safeGet(w2Variant, variant) :+ word
          }
          w2Variant
        }
      }

    // println(scala.runtime.ScalaRunTime.stringOf(wordsAdjToVariant))

    val q = mutable.Queue[(String, Int)]((beginWord, 1)) // word to level tuple
    val visited = mutable.HashMap[String, Boolean](beginWord -> true) // visited

    while (!q.isEmpty) {
      val (cWord, cLevel) = q.dequeue
      for (i <- 0 until len) {
        val cWordVariant = getVariant(i, cWord, len)
        for (adjWord <- safeGet(wordsAdjToVariant, cWordVariant)) {
          if (adjWord == endWord) return cLevel + 1
          else if (!visited.contains(adjWord)) {
            visited(adjWord) = true
            q += (adjWord -> (cLevel + 1))
          }
        }
      }
    }

    NO_PATHS_POSSIBLE
  }

  private def getVariant(i: Int, word: String, len: Int): String = {
    s"${word.substring(0, i)}*${word.substring(i + 1, len)}"
  }

  private def safeGet(
      map: mutable.HashMap[String, mutable.ListBuffer[String]],
      key: String
  ): mutable.ListBuffer[String] = {
    map.getOrElse(key, mutable.ListBuffer[String]())
  }
}

/*
G: beginWord: String, endWord: String, wordList: List[String]
O: shortestTransformSequence: Int
T: O(nm) where n is the length of word list and m is the length of longest word
S: O(nm) // not sure if we will need all of it

Notes:
  - shortestTransformSequence is sequence of steps from beginWord to endWord such that:
    ^ Only one letter can be changed at a time.
    ^ Each transformed word must exist in the word list.
  - This seems like an exhaustive search with choose explore unchoose backtracking algorithm
  - I am thinking of traversing as BFS, sort of check all the unvisited letters each time and see if ur done


Ex:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]





Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

 */
