object Solution {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    val rows = matrix.length
    val cols = matrix(0).length
    val dp = Array.ofDim[Int](rows + 1, cols + 1)
    var maxLen = 0

    for (i <- 1 to rows) {
      for (j <- 1 to cols) {
        if (matrix(i - 1)(j - 1) == '1') {
          dp(i)(j) = (dp(i - 1)(j) min dp(i)(j - 1) min dp(i - 1)(j - 1)) + 1
          maxLen = maxLen max dp(i)(j)
        }
      }
    }

    maxLen * maxLen
  }
}

/*
G: matrix: Array[Array[Char]]
O: maxMatrix: Int
T: O(n)
S: O(n)

Notes:
  - filled with 0's and 1's
  - find the largest square containing only 1's and return its area.

Ex:

 */
