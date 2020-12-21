object Solution {
  def longestPalindrome(s: String): String = {
    if (s == null || s.isEmpty) return ""

    val (start, end) = (0 until s.length).foldLeft((0, 0)) {
      case ((start, end), idx) => {
        val oddPal = expand(s, idx, idx)
        val evenPal = expand(s, idx, idx + 1)

        val maxLen = oddPal max evenPal
        if (maxLen > end - start) {
          // doing this will make answer same for odd size (n around the petal) and diff for odd size. Odd size will include current letter @ idx
          val nStart = idx - (maxLen - 1) / 2
          val nEnd = idx + (maxLen / 2)
          (nStart, nEnd)
        } else (start, end)
      }
    }

    s.substring(start, end + 1) // + 1 to be inclusive of end
  }

  private def expand(s: String, left: Int, right: Int): Int = {
    var l = left
    var r = right

    while (l >= 0 && r < s.length && s(l) == s(r)) {
      l -= 1
      r += 1
    }

    // the loop above will stop when over expanded, we would remove 2, but due to 0 counting we only need to remove 1
    (r - l) - 1
  }
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
