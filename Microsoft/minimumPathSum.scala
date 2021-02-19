object Solution {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty) return 0 // short circuit
    val (iLen, jLen) = (grid.length, grid.head.length)
    val brain = Array.fill[Int](iLen, jLen)(0)
    brain(0)(0) = grid(0)(0)

    for (i <- 0 until iLen; j <- 0 until jLen; if !(i == 0 && j == 0)) {
      val left = if (j - 1 >= 0) brain(i)(j - 1) else Int.MaxValue
      val up = if (i - 1 >= 0) brain(i - 1)(j) else Int.MaxValue
      brain(i)(j) = grid(i)(j) + (up min left)
    }

    brain.last.last
  }
}

/*
G: grid: Array[Array[Int]]
O: sumWithMinCost: Int
T: O(mn)
S: O(mn)

Notes:
  - Grid is filled with non-negative numbers.
  - Find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
  - You can only move either down or right at any point in time.

Ex:

 */
