object Solution {
  def isPalindrome(s: String): Boolean = {
    // cs is "cleaned string"
    val cs = s.filterNot(_.isWhitespace).filter(_.isLetterOrDigit).toLowerCase
    cs == cs.reverse
  }
}

/*
G: s: String
O: validPallindrome: Boolean
T: O(n)
S: O(n)

Notes:
  - Alphanumeric chars
  - Ignoring cases
  - Empty string is a valid palindrome
 */
