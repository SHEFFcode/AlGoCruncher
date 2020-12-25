import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashMap
object Solution {
  def wordSquares(words: Array[String]): List[List[String]] = {
    val result = ListBuffer[ListBuffer[String]]()
    val map = createPrefixMap(words)
    for (i <- 0 until words.length) {
      val cList = ListBuffer[String](words(i))
      backTrack(1, cList, result, words(i).length, map)
    }

    result.map(_.toList).toList
  }

  private def backTrack(
      step: Int,
      list: ListBuffer[String],
      result: ListBuffer[ListBuffer[String]],
      len: Int,
      map: HashMap[String, ListBuffer[String]]
  ): Unit = {
    if (list.size == len) {
      result += list.clone
      return ()
    }
    val sb = new StringBuilder()
    for (word <- list) sb.append(word(step))
    val prefix = sb.toString()
    val wordList = map.getOrElse(prefix, ListBuffer[String]())

    for (word <- wordList) {
      list += word
      backTrack(step + 1, list, result, len, map)
      list.remove(list.size - 1)
    }
  }

  private def createPrefixMap(
      words: Array[String]
  ): HashMap[String, ListBuffer[String]] = {
    words.foldLeft(HashMap[String, ListBuffer[String]]()) {
      case (map, word) => {
        for (i <- 0 until word.length) {
          val prefix = word.substring(0, i)
          map(prefix) = map.getOrElse(prefix, ListBuffer[String]()) :+ word
        }
        map
      }
    }
  }
}

/*
G: words: Array[String]
O: allWordSquares: List[List[String]]
T: O(N⋅26^L) where L is the length of a single word
S: O(N⋅L) where L is the length of a single word

Notes:
  - Given a set of words (without duplicates)
  - There are at least 1 and at most 1000 words.
  - All words will have the exact same length.
  - Word length is at least 1 and at most 5.
  - Each word contains only lowercase English alphabet a-z.

Ex:
Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

 */
