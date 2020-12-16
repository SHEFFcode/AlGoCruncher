object Solution {
  val dirs = Array((0, 1), (1, 0), (0, -1), (-1, 0))
  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
    if (!validInput(matrix)) return 0

    val (m, n) = (matrix.length, matrix(0).length)
    val brain = Array.ofDim[Int](m, n)
    var longestPath = 0

    for (i <- 0 until m; j <- 0 until n) {
      longestPath = longestPath max traverse(matrix, i, j, brain)
    }

    longestPath
  }

  private def traverse(
      matrix: Array[Array[Int]],
      i: Int,
      j: Int,
      brain: Array[Array[Int]]
  ): Int = {
    if (brain(i)(j) != 0) return brain(i)(j)
    val (m, n) = (matrix.length, matrix(0).length)
    for (dir <- dirs) {
      val (x, y) = (i + dir._1, j + dir._2)
      if (x > -1 && x < m && y > -1 && y < n && matrix(x)(y) > matrix(i)(j)) {
        brain(i)(j) = brain(i)(j) max traverse(matrix, x, y, brain)
      }
    }
    brain(i)(j) += 1
    brain(i)(j)
  }

  private def validInput(matrix: Array[Array[Int]]): Boolean = {
    matrix.length != 0
  }
}

/*
G: matrix: Array[Array[Int]]
O: longestPath: Int
T: O(N)
S: O(N) at most if longest path is the whole matrix

Notes:
  - You can only move up, down, left, right and not diagonally
  - Wrap around is not allowed

Ex:
Input: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].


9 9 4
6 6 8
2 1 1

More or less we will do a graph traversal with the max length variable somewhere
If we see a path that is longest then the one we already made, we will update it

 */
