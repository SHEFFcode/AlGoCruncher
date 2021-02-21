import scala.collection.mutable.Queue
object Solution {
  private val FOOD = '#'
  private val YOU = '*'
  private val OBSTACLE = 'X'
  private val NOT_POSSIBLE = -1
  def getFood(grid: Array[Array[Char]]): Int = {
    val n = grid.length
    val m = grid.head.length
    val dirs = Array((0, 1), (0, -1), (1, 0), (-1, 0))
    val q = Queue[(Int, Int, Int)]() // (x, y, dist)

    for (i <- 0 until n) {
      for (j <- 0 until m) {
        if (grid(i)(j) == FOOD) {
          q += new Tuple3(i, j, 0)
        }
      }
    }

    while (q.nonEmpty) {
      val (prevX, prevY, pDist) = q.dequeue

      for (dir <- dirs) {
        val (dirX, dirY) = dir
        val x = prevX + dirX
        val y = prevY + dirY
        if (validPoint(grid, x, y)) {
          if (grid(x)(y) == YOU) return pDist + 1
          else {
            grid(x)(y) = OBSTACLE
            q += new Tuple3(x, y, pDist + 1)
          }
        }
      }
    }
    NOT_POSSIBLE
  }

  private def validPoint(grid: Array[Array[Char]], x: Int, y: Int): Boolean = {
    x > -1 &&
    y > -1 &&
    x < grid.length &&
    y < grid.head.length &&
    grid(x)(y) != OBSTACLE
  }
}

/*
G: grid: Array[Array[Char]]
O: shortestPath: Int
T: O(mn)
S: O(mn)

Notes:
  - You are given an m x n character matrix, grid, of these different types of cells:
    ^ '*' is your location. There is exactly one '*' cell.
    ^ '#' is a food cell. There may be multiple food cells.
    ^ 'O' is free space, and you can travel through these cells.
    ^ 'X' is an obstacle, and you cannot travel through these cells.
  - You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.
  - Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.

Ex:

 */
