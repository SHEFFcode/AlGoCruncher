import scala.collection.mutable
object Solution extends App {
  def lengthOfLongestSubstring(s: String): Int = {
    val charsInWndw = mutable.HashSet[Int]()
    var left = 0
    var longest = 0

    for (right <- 0 until s.length) {
      val rChar = s(right)
      if (charsInWndw.contains(rChar)) {
        longest = longest max (right - left) // cool math
        while (charsInWndw.contains(rChar)) {
          val lChar = s(left)
          charsInWndw -= lChar
          left += 1
        }
      } else if (right == s.length() - 1) {
        longest = longest max (right - left) + 1
      }
      charsInWndw += rChar
    }
    longest
  }

  println(lengthOfLongestSubstring("pwwkew"))
}

/*
G: s: String
O: longstSubstringNoRepeat: Int
T: O(N)
S: O(N) possibly O(1)

Notes:
  - s consists of english letters digits and spaces

Ex:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

{
  a: 3
  b: 4
  c: 5
}
longest = arr.length + 1, 3,

0 1 2 3 4 5 6 7
a b c a b c b b
      i
            j
 */
