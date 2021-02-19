import scala.collection.mutable.HashMap
object Solution {
  val goalX: Int = 0
  val goalY: Int = 0
  val brain: HashMap[String, Int] = HashMap[String, Int]()
  def uniquePaths(m: Int, n: Int): Int = {
    goalX = m - 1 // 0 based counting
    goalY = n - 1 // 0 based counting
    brain = HashMap[String, Int]()
    traverse(0, 0)
  }

  private def traverse(x: Int, y: Int): Int = {
    if (x == goalX && y == goalY) 1
    else if (x > goalX || y > goalY) 0
    else {
      val position = s"$x,$y"
      if (!brain.contains(position)) {
        brain(position) = traverse(x + 1, y) + traverse(x, y + 1)
      }
      brain(position)
    }
  }
}

/*
G: m: Int, n: Int
O: numberOfPaths: Int
T: mn
S: mn

Notes:
  - Robot is located in the top left corner.
  - The robot can only move either down or right at any point in time.
  - How many unique paths are there

Ex:

 */
