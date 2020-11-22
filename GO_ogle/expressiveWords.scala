import scala.collection.mutable.ArrayBuffer
object Solution extends App {
  def expressiveWords(S: String, words: Array[String]): Int = {
    val (sKey, sCount) = createKeyCount(S)
    var expressiveCount = 0

    for (word <- words) {
      val (wKey, wCount) = createKeyCount(word)

      if (sKey == wKey) {
        val res = (0 until sCount.size).foldLeft(true) {
          case (succeeds, idx) => {
            val sCnt4Char = sCount(idx)
            val wCnt4Char = wCount(idx)
            succeeds && (sCnt4Char == wCnt4Char || sCnt4Char >= (wCnt4Char max 3))
          }
        }

        if (res == true) expressiveCount += 1
      }
    }

    expressiveCount
  }

  def createKeyCount(s: String): (String, Array[Int]) = {
    val key = new StringBuilder()
    val count = ArrayBuffer[Int]()
    val sLen = s.length()
    var l = -1

    for (r <- 0 until sLen) {
      if (r == sLen - 1 || s(r) != s(r + 1)) {
        key += s(r)
        count += r - l
        l = r
      }
    }

    (key.toString(), count.toArray)
  }

  println(expressiveWords("heeellooo", Array("hello", "hi", "helo")))
}

/*
G: S: String, words: Array[String]
O: numStretchyWords: Int
T: O(N)
S: O(N)

Notes:
  - Stretchy is considered when a group of characters c is of size 3 of more
  -

Ex:

Example:
Input:
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation:
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.

{
  "hello"
  "hi"
  "helo"
}

inARow = 3

0 1 2 3 4 5 6 7 8
h e e e l l l o o o
            i
                j

StringBuilder key = "helo"
                    [1333]

"h e l o"
[1 3 3 3]
vs
"h e l o"
[1 1 2 1]

Step1: Come up with key, count pair for given word and word in the dictionary
Step2: If the count of char at each index is the same, or the count the S is >= max(count in dictS, 3), or the 2 counts are identical, increment


 */
