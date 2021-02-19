import scala.collection.mutable.HashMap
object Solution {
  private type Grid = Array[Array[Int]]
  private var goalX: Int = 0
  private var goalY: Int = 0
  private var brain: HashMap[String, Int] = HashMap[String, Int]()
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    goalX = obstacleGrid.length - 1 // 0 based counting
    goalY = obstacleGrid.head.length - 1 // 0 based counting
    brain = HashMap[String, Int]()
    traverse(0, 0, obstacleGrid)
  }

  private def traverse(x: Int, y: Int, grid: Grid): Int = {
    if (x > goalX || y > goalY || grid(x)(y) == 1) 0
    else if (x == goalX && y == goalY) 1
    else {
      val position = s"$x,$y"
      if (!brain.contains(position)) {
        brain(position) = traverse(x + 1, y, grid) + traverse(x, y + 1, grid)
      }
      brain(position)
    }
  }
}

/*
G: obstacleGrid: Array[Array[Int]]
O: numPathsWithObstacles: Int
T: O(mn)
S: O(mn)

Notes:
  - A robot is located at the top-left corner
  - The robot can only move either down or right at any point in time.
  - The robot is trying to reach the bottom-right corner of the grid
  - Now consider if some obstacles are added to the grids. How many unique paths would there be?
  - An obstacle and space is marked as 1 and 0 respectively in the grid.

Ex:

 */
