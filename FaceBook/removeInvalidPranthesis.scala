object Solution {
  var ogString: String = ""
  var ans = List[String]()
  def removeInvalidParentheses(s: String): List[String] = {
    ogString = s
    ans = List[String]()

    // Step 1: Calculate left and right extras
    val (lExtra, rExtra) = s.foldLeft((0, 0)) {
      case ((lExtra, rExtra), char) =>
        char match {
          case '(' => (lExtra + 1, rExtra)
          case ')' => {
            if (lExtra > 0) (lExtra - 1, rExtra)
            else (lExtra, rExtra + 1)
          }
          case _ => (lExtra, rExtra)
        }
    }

    // println(lExtra, rExtra)
    // Create a list of possible answers
    dfs(0, "", 0, lExtra, rExtra)
    // Return distinct answers
    ans.distinct
  }

  private def dfs(
      idx: Int,
      cStr: String,
      lNoMatch: Int,
      lExtra: Int,
      rExtra: Int
  ): Unit = {
    // If we have reached the length of original string
    if (idx >= ogString.length()) {
      // And we don't have any unmatched left open brackets
      if (lNoMatch == 0) ans ::= cStr // add to results
      return
    }

    // match a char
    ogString(idx) match {
      case c @ '(' =>
        if (lExtra > 0) {
          // If we have some lExtras to get rid of, do it
          // without adding any chars to the cString
          dfs(idx + 1, cStr, lNoMatch, lExtra - 1, rExtra)
        }
        // ALSO look if you can count this as yet to be matched
        // opening brace, while adding to the cString
        dfs(idx + 1, cStr + c, lNoMatch + 1, lExtra, rExtra)
      case c @ ')' =>
        if (rExtra > 0) {
          // IF we have some rExtras, reduce the count
          // without adding to the cString
          dfs(idx + 1, cStr, lNoMatch, lExtra, rExtra - 1)
        }
        if (lNoMatch > 0) {
          // If there are lNoMatches, reduce them by adding to the
          // cString to close out the unmatched opening brace
          dfs(idx + 1, cStr + c, lNoMatch - 1, lExtra, rExtra)
        }
      case c @ _ =>
        // Just add to the cString as is.
        dfs(idx + 1, cStr + c, lNoMatch, lExtra, rExtra)
    }
  }
}

/*
G: s: String
O: allPossibleResults: List[String]
T: Any
S: Any

Notes:
  - The input string may contain letters other than the parentheses ( and )


Ex:

 */
