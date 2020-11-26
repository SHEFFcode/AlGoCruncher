object Solution extends App {
  val UNEXPLORED_LAND = '1'
  val EXPLORED_LAND = 'x'
  def numIslands(grid: Array[Array[Char]]): Int = {
    var numberOfIslands = 0
    val n = grid.length
    val m = grid(0).length

    for (i <- 0 until n) {
      for (j <- 0 until m) {
        if (grid(i)(j) == UNEXPLORED_LAND) {
          exploreTheIsland(i, j, grid)
          numberOfIslands += 1
        }
      }
    }
    numberOfIslands
  }

  def exploreTheIsland(i: Int, j: Int, grid: Array[Array[Char]]): Unit = {
    if (
      i < grid.length && i > -1
      && j < grid(0).length && j > -1
      && grid(i)(j) == UNEXPLORED_LAND
    ) {
      grid(i)(j) = EXPLORED_LAND
      exploreTheIsland(i + 1, j, grid) // look right
      exploreTheIsland(i - 1, j, grid) // look left
      exploreTheIsland(i, j + 1, grid) // look down
      exploreTheIsland(i, j - 1, grid) // look up

    }
  }

  // println(
  //   numIslands(
  //     Array(
  //       Array('1', '1', '1', '1', '0'),
  //       Array('1', '1', '0', '1', '0'),
  //       Array('1', '1', '0', '0', '0'),
  //       Array('0', '0', '0', '0', '0')
  //     )
  //   )
  // )
  // println(
  //   numIslands(
  //     Array(
  //       Array('1', '1', '0', '0', '0'),
  //       Array('1', '1', '0', '0', '0'),
  //       Array('0', '0', '1', '0', '0'),
  //       Array('0', '0', '0', '1', '1')
  //     )
  //   )
  // )
  println(
    numIslands(
      Array(
        Array('1', '1', '1'),
        Array('0', '1', '0'),
        Array('1', '1', '1')
      )
    )
  )
}

/*
[["1","1","1"],["0","1","0"],["1","1","1"]]*/

/*
G: grid: Array[Array[Char]]
O: numberOfIslands: Int
T: O(n)
S: O(n)

Notes:
  - An island is surrounded by water an is formed by connecting adjacent lands horizontally and vertically
  - You may assume that all four edges of the grid are surrounded by water
  - Recursive solution
  - Grid will be m by n
  - Global counter variable
  - If you hit an island, move in 4 cardinal directions while you are on land.
    ^ Right, down, left, up.

Ex:

Input: grid = [
  ["1","1","1","1","0"],
                i
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Ex2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3



 */
