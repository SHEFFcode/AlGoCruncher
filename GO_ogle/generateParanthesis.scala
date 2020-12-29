object Solution {
  def generateParenthesis(n: Int): List[String] = {
    backTrack(List[String](), "", n, n)
  }

  private def backTrack(
      ans: List[String],
      cur: String,
      open: Int,
      close: Int
  ): List[String] = {
    if (open == 0 && close == 0) ans :+ cur
    else {
      if (open > 0) {
        // we can open a bracket
        val intermediate = backTrack(ans, cur + "(", open - 1, close)
        // we can close a bracket
        if (open < close) backTrack(intermediate, cur + ")", open, close - 1)
        else intermediate
      } else {
        // we can only close
        backTrack(ans, cur + ")", open, close - 1)
      }
    }
  }
}

/*
G: n: Int
O: paranthesis: List[String]
T: ??? too rigorous to make
S: O(N)

Notes:

Ex:

 */
