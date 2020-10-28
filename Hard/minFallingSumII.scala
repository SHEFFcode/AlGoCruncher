object Solution {
  def minFallingPathSum(arr: Array[Array[Int]]): Int = {
    val dim = arr.length
    val brain = arr.clone()

    for (row <- 1 until dim) {
      for (col <- 0 until dim) {
        val pRow = row - 1
        val pRowSansCol = arr(pRow).slice(0, col) ++ arr(pRow).drop(col + 1)
        brain(row)(col) += pRowSansCol.min
      }
    }

    brain(dim - 1).min
  }
}

/*
G: squareGrid: Array[Array[Int]]
O: minSumFallingPath: Int
T: O(N)
S: O(N)

Notes:
 * Select exactly 1 element from each row
 * No 2 rows can have items from same col

[[1,2,3],[4,5,6],[7,8,9]] => 13

1 2 3
4 5 6
7 8 9



 */
