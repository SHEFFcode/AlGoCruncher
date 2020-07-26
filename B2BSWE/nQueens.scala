/*
G: n: Int <- the size of the n x n board
O: possibleSolutions: List[List[String]] 
T: ???
S: ???
Notes:
  * The board configuration is like so: Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]




  |   | x |    |   |
  |   |   |    | x |
  | x |   |   |   |
  |   |   | x |   |

*/


object Solution {
    var possibleSolutions = List[List[String]]()
    def solveNQueens(n: Int): List[List[String]] = {
        possibleSolutions = List[List[String]]()
        val memory = Array.ofDim[Int](n)
        runSolver(memory, 0, n)
    }

    def runSolver(memory: Array[Int], currentRow: Int, n: Int): List[List[String]] = {
        
      if (currentRow == n) {
        // this means we got a solution, let's add it to the list and return the list
        possibleSolutions :+ memory.foldLeft(List[String]()) { (acc, item) => {
          val sb = new StringBuilder(n, "." * n)
          sb.replace(item, item + 1, "Q")
          acc :+ sb.toString()
        }}
        
      } else {
        for (possibleColumn <- 0 until n) {
          memory(currentRow) = possibleColumn
          if (isValid(memory, currentRow) == true) {
              val result = runSolver(memory, currentRow + 1, n)
            if (result.size > 0) {
                possibleSolutions = result
            }
          }
        }
          possibleSolutions
      }
    }

    def isValid(memory: Array[Int], currentRow: Int): Boolean = {
      for (column <- 0 until currentRow) {
        val diff = Math.abs(memory(column) - memory(currentRow))
        if (diff == 0 || diff == currentRow - column) {
          return false
        }
      }
        true
    }
}