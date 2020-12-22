class NumMatrix(_matrix: Array[Array[Int]]) {
  var dp: Array[Array[Int]] = Array.ofDim[Int](1, 1) // initially
  if (_matrix.length != 0 && _matrix(0).length != 0) { // range scan possible
    dp = Array.ofDim[Int](_matrix.size + 1, _matrix(0).size + 1) // + 1 makes code easier
    for (r <- 0 until _matrix.length) {
      for (c <- 0 until _matrix(0).length) {
        dp(r + 1)(c + 1) = dp(r + 1)(c) + dp(r)(c + 1) + _matrix(r)(c) - dp(r)(c)
      }
    }
  }

  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
      dp(row2 + 1)(col2 + 1) - dp(row1)(col2 + 1) - dp(row2 + 1)(col1) + dp(row1)(col1)
  }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */

 /*
 G: 2dMatrix: Array[Array[Int]] row1: Int, col1: Int, ro2: Int, col2: Int
 O: rangeSum: Int
 T: O(N)
 S: O(N)
 
 Notes:
  - find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
  - You may assume that the matrix does not change.
  - There are many calls to sumRegion function.
  - You may assume that row1 ≤ row2 and col1 ≤ col2.
 
 Ex:
 Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12


 */
