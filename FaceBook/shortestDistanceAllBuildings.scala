import scala.collection.mutable.HashMap
import scala.collection.mutable.Queue
object Solution {
  val BUILDING = 1
  val EMPTY_LAND = 0
  def shortestDistance(grid: Array[Array[Int]]): Int = {
    if (invalid(grid)) return -1

    val numHouses = grid.map(_.count(_ == 1)).sum
    val distanceFromSquareToBuildings =
      Array.ofDim[Int](grid.length, grid(0).length)
    val buildingsAccessibleFromSquare =
      Array.ofDim[Int](grid.length, grid(0).length)

    for (i <- 0 until grid.length; j <- 0 until grid(0).length) {
      // why BFS, we want the closest path to all buildings. BFS gets that first
      bfs(
        grid,
        i,
        j,
        distanceFromSquareToBuildings,
        buildingsAccessibleFromSquare
      )
    }

    // after BFS is complete from every spot in the graph (from every building)
    // we can find the mind distance where every building has been hit
    var shortest = Int.MaxValue
    for (i <- 0 until grid.length; j <- 0 until grid(0).length) {
      if (
        grid(i)(j) == EMPTY_LAND &&
        buildingsAccessibleFromSquare(i)(j) == numHouses
      ) {
        shortest = shortest min distanceFromSquareToBuildings(i)(j)
      }
    }

    if (shortest == Int.MaxValue) -1 else shortest
  }

  def bfs(
      grid: Array[Array[Int]],
      i: Int,
      j: Int,
      d: Array[Array[Int]], // distanceFromSquareToBuildings
      b: Array[Array[Int]] // buildingsAccessibleFromSquare
  ): Unit = {
    // we only care about distance to all buildings, so we
    // will only do our BFS from an existing building
    if (grid(i)(j) == BUILDING) {
      val q = Queue[(Int, Int)]((i, j)) // q of points (x, y)
      val visited = Array.ofDim[Boolean](grid.length, grid(0).length)
      var distanceFromOGBuilding = 0

      while (!q.isEmpty) {
        // here we want a notion of distances from building
        // which is why we want to go out in layers
        // as we get further and further away from a building
        // we want ot increase that variable, and keep track of it in
        // our distanceFromSquareToBuildings matrix
        val qSize = q.size // snap shot of size at this point
        for (l <- 0 until qSize) {
          val (x, y) = q.dequeue()

          if (!visited(x)(y)) {
            if (grid(x)(y) == EMPTY_LAND) {
              d(x)(y) += distanceFromOGBuilding
              b(x)(y) += 1
            }
            visited(x)(y) = true

            if (validNeighbor(grid, x + 1, y, visited)) q.enqueue((x + 1, y))
            if (validNeighbor(grid, x - 1, y, visited)) q.enqueue((x - 1, y))
            if (validNeighbor(grid, x, y + 1, visited)) q.enqueue((x, y + 1))
            if (validNeighbor(grid, x, y - 1, visited)) q.enqueue((x, y - 1))

          }
        }
        distanceFromOGBuilding += 1
      }
    }
  }

  private def validNeighbor(
      grid: Array[Array[Int]],
      i: Int,
      j: Int,
      visited: Array[Array[Boolean]]
  ): Boolean = {
    i > -1 && j > -1 &&
    i < grid.length && j < grid(0).length &&
    grid(i)(j) == EMPTY_LAND &&
    visited(i)(j) == false
  }

  private def invalid(grid: Array[Array[Int]]): Boolean = {
    grid == null || grid.length == 0 || grid(0) == null || grid(0).length == 0
  }
}

/*
G: grid: Array[Array[Int]]
O: shortestDistanceFromBuildings: Int
T: O(n)
S: O(n)

Notes:
  - Each 0 marks an empty land which you can pass by freely.
  - Each 1 marks a building which you cannot pass through.
  - Each 2 marks an obstacle which you cannot pass through.

Ex:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total
             travel distance of 3+3+1=7 is minimal. So return 7.


Steps:
  - Count the total number of buildings in a grid
  - Start in each square, it it's a zero start recursion until you find all buildings
  - If that number is less then lowestSoFar, make the new number lowest

 */
