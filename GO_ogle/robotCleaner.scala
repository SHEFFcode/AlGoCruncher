import scala.collection.mutable.HashSet

/**
  * // This is the robot's control interface.
  * // You should not implement it, or speculate about its implementation
  * class Robot {
  *     // Returns true if the cell in front is open and robot moves into the cell.
  *     // Returns false if the cell in front is blocked and robot stays in the current cell.
  *     def move(): Boolean = {}
  *
  *     // Robot will stay in the same cell after calling turnLeft/turnRight.
  *     // Each turn will be 90 degrees.
  *     def turnLeft(): Unit = {}
  *     def turnRight(): Unit = {}
  *
  *     // Clean the current cell.
  *     def clean(): Unit = {}
  * }
  */

object Solution {
  val dirs = Array((-1, 0), (0, 1), (1, 0), (0, -1))

  def cleanRoom(robot: Robot): Unit = {
    traverse(HashSet[String](), 0, 0, robot, 0)
  }

  private def traverse(
      brain: HashSet[String],
      i: Int,
      j: Int,
      robot: Robot,
      direction: Int
  ): Unit = {
    robot.clean()
    brain += s"$i:$j"
    for (dir <- 0 to 3) {
      // if u come in at direction 3, and u want to go in direction 3
      // for you it would be as if u went in direction 2 on absolute coordinates
      val absoluteDir = (dir + direction) % 4
      val (iAdd, jAdd) = dirs(absoluteDir)
      if (!brain.contains(s"${i + iAdd}:${j + jAdd}") && robot.move()) {
        traverse(brain, i + iAdd, j + jAdd, robot, absoluteDir)
        goBack(robot)
      }
      robot.turnRight()
    }
  }

  private def goBack(robot: Robot): Unit = {
    for (_ <- 0 to 1) robot.turnRight
    robot.move()
    for (_ <- 0 to 1) robot.turnRight
  }
}

/*
G: robot: Robot
O: cleanEntireRoom: Unit
T: O(N)
S: O(N)

Notes:
  - The robot's initial position will always be in an accessible cell.
  - The initial direction of the robot will be facing up.
  - All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
  - Assume all four edges of the grid are all surrounded by wall.
  - 0 means the cell is blocked, while 1 means the cell is accessible.

Ex:

   0 1 2 3 4 5 6 7
0  [1 1 1 1 1 0 1 1]
1  [1 1 x 1 1 0 1 1]
2  [1 0 1 1 1 1 1 1]
3  [0 0 0 1 0 0 0 0]
4  [1 1 1 1 1 1 1 1]


   0 1 2 3 4 5 6 7
0  [ d d l r 0 1 1]
1  [d d u d 1 0 1 1]
2  [d 0 1 1 1 1 1 1]
3  [0 0 0 1 0 0 0 0]
4  [1 1 1 1 1 1 1 1]


up()
left()
right()
down()


{
  (0,0): true
}
 */
