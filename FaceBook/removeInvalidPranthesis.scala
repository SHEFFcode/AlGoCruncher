object Solution {
  var ogString: String = ""
  var ans = List[String]()
  def removeInvalidParentheses(s: String): List[String] = {
    ogString = s
    ans = List[String]()

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

    println(lExtra, rExtra)

    dfs(0, "", 0, lExtra, rExtra)
    ans.distinct
  }

  private def dfs(
      idx: Int,
      cStr: String,
      lNoMatch: Int,
      lExtra: Int,
      rExtra: Int
  ): Unit = {
    if (idx >= ogString.length()) {
      if (lNoMatch == 0) ans ::= cStr
      return
    }

    ogString(idx) match {
      case c @ '(' =>
        if (lExtra > 0) {
          dfs(idx + 1, cStr, lNoMatch, lExtra - 1, rExtra)
        }
        dfs(idx + 1, cStr + c, lNoMatch + 1, lExtra, rExtra)
      case c @ ')' =>
        if (rExtra > 0) {
          dfs(idx + 1, cStr, lNoMatch, lExtra, rExtra - 1)
        }
        if (lNoMatch > 0) {
          dfs(idx + 1, cStr + c, lNoMatch - 1, lExtra, rExtra)
        }
      case c @ _ =>
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
