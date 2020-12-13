object Solution {
  val LAND = '1'
  val WATER = '0'
  val EXPLORED = 'x'
  val FOUND_ISLAND = true
  val NO_ISLAND = false
  def numIslands(grid: Array[Array[Char]]): Int = {
    val g = grid.clone() // we don't want to modify input
    var islandCount = 0

    for (i <- 0 until g.length) {
      for (j <- 0 until g(0).length) {
        if (explore(grid, i, j)) islandCount += 1
      }
    }
    islandCount
  }

  private def explore(g: Array[Array[Char]], i: Int, j: Int): Boolean = {
    if (inbounds(g, i, j) && g(i)(j) != EXPLORED && g(i)(j) == LAND) {
      g(i)(j) = EXPLORED
      explore(g, i + 1, j)
      explore(g, i - 1, j)
      explore(g, i, j + 1)
      explore(g, i, j - 1)
      FOUND_ISLAND
    } else NO_ISLAND
  }

  private def inbounds(g: Array[Array[Char]], i: Int, j: Int): Boolean = {
    i > -1 && j > -1 && i < g.length && j < g(i).length
  }
}
