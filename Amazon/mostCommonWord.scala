import scala.collection.mutable.HashMap

object Solution {
  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    val bSet = banned.toSet
    val wordCount = HashMap[String, Int]()
    val wordBuffer = new StringBuilder()
    var ans = ""
    var maxCount = 0

    for (idx <- 0 until paragraph.length) {
      val c = paragraph(idx)
      if (c.isLetter) {
        wordBuffer.append(c.toLower)
      } else if (wordBuffer.length > 0 || idx == paragraph.length - 1) {
        val word = wordBuffer.toString
        if (!bSet.contains(word)) {
          val newCount = wordCount.getOrElse(word, 0) + 1
          wordCount(word) = newCount
          if (newCount > maxCount) {
            ans = word
            maxCount = newCount
          }
        }
        wordBuffer.clear()
      }
    }

    ans
  }
}

/*
G: paragraph: String, banned: Array[String]
O: mostCommonWord: String
T: O(N+M) N be the number of characters in the input string and MM be the number of characters in the banned list.
S: O(N+M)

Notes:

Ex:

 */
