import scala.collection.mutable.HashMap
object Solution {
  def numDecodings(s: String): Int = {
    traverse(0, s, HashMap[Int, Int]())
  }

  private def traverse(i: Int, s: String, brain: HashMap[Int, Int]): Int = {
    val len = s.length()
    if (i == len) return 1 // in case we took 2 and ended up past str length - 1
    if (i == len - 1) {
      s(i) match {
        case '0' => return 0 // 0 by itself not an answer per notes
        case _   => return 1 // can be at most 1 answer
      }
    }
    if (brain.contains(i)) return brain(i)

    var ans = traverse(i + 1, s, brain)
    if (s.substring(i, i + 2).toInt < 27) { // 26 letters in US alphabet
      ans += traverse(i + 2, s, brain)
    }

    brain(i) = ans
    ans
  }
}

/*
G: s: String
O: numDecodings: Int
T: O(N)
S: O(N)

Notes:
  - A message containing letters from A-Z
  - 'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
  - Given a non-empty string containing only digits, determine the total number of ways to decode it.
  - The answer is guaranteed to fit in a 32-bit integer.
Ex:

Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Ex2:

Input: s = "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Ex3:
Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with '0'. We cannot ignore a zero when we face it while decoding. So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.

Ex4:
Input: s = "1"
Output: 1


 */
