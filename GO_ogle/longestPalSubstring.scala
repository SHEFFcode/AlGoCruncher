object Solution extends App {
  def longestPalindrome(s: String): String = {
    if (s.isEmpty) return ""

    val (start, end, _) = (0 until s.length).foldLeft((0, 0, 0)) {
      case ((start, end, maxLen), idx) => {
        //aba
        val oddPal = expand(idx, idx, s)
        //abba
        val evenPal = expand(idx, idx + 1, s)
        val maxPal = oddPal max evenPal

        if (maxPal > maxLen) {
          val nStart =
            idx - (maxPal - 1) / 2 // to make it diff for even and odd
          val nEnd = idx + maxPal / 2
          (nStart, nEnd, maxPal)
        } else (start, end, maxLen)
      }
    }

    s.substring(start, end + 1) // to make up for end being exclusive
  }

  private def expand(left: Int, right: Int, s: String): Int = {
    var l = left
    var r = right

    while (l > -1 && r < s.length && s(l) == s(r)) {
      l -= 1
      r += 1
    }

    r - l - 1 // the loop above would have overexpanded, reduce by 1 for 0 based count
  }

  println(longestPalindrome("babad"))
  println(longestPalindrome("cbbd"))
  println(longestPalindrome("a"))
  println(longestPalindrome("ac"))
}

/*
G: s: String
O: longestPalindromicSubstring: String
T: O(N)
S: O(N) at most?

Notes:
  - General idea is to see if its palindromic now
    ^ If not is it palindromic without first letter
    ^ If not is it palindromic without the last letter
    ^ If not is it palindromic without both first and last letter

Ex:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

babad
 *
    #
 */
