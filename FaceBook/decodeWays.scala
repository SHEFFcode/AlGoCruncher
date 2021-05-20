import scala.collection.mutable.HashMap
object Solution {
  def numDecodings(s: String): Int = {
    traverse(0, s, HashMap[Int, Int]())
  }

  private def traverse(idx: Int, s: String, brain: HashMap[Int, Int]): Int = {
    idx match {
      case i if i == s.length => 1
      case i if s(i) == '0' =>
        0 // if starts with 0, ans is 0 and 0 at the end would not add to the answer.
      case i if i == s.length - 1 => 1
      case i if brain.contains(i) => brain(i)
      case i => {
        var ans = rec(i + 1)
        if (s.substring(i, i + 2).toInt <= 26) { // 26 us letters
          ans += rec(i + 2)
        }
        brain(i) = ans
        ans
      }
    }
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
