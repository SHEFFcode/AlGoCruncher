object Solution {
  private type Matrix = Array[Array[Int]]
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    var area = 0
    val xIdxs = grid.indices
    val yIdxs = grid.head.indices
    // DFS to find area of current island
    for (i <- xIdxs; j <- yIdxs)
      area = area max dfs(grid, i, j, grid.length, grid(0).length)
    area
  }
  def dfs(grid: Matrix, row: Int, col: Int, w: Int, h: Int): Int = {
    // Out of bounds || visited
    if (row < 0 || row >= w || col < 0 || col >= h || grid(row)(col) == 0) 0
    else {
      // Ahoy, land!
      grid(row)(col) = 0
      // ↓ -> ↑ <-
      1 +
        dfs(grid, row + 1, col, w, h) +
        dfs(grid, row, col + 1, w, h) +
        dfs(grid, row - 1, col, w, h) +
        dfs(grid, row, col - 1, w, h)
    }
  }
}

/*
G: grid: Array[Array[Int]]
O: maxAreaIsland: Int
T: O(nm)
S: O(1)

Notes:
  - Given a non-empty 2D array grid of 0's and 1's
  - An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
  - You may assume all four edges of the grid are surrounded by water.
  - Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Ex:

 */
