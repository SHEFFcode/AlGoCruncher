object Solution {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    val rowsValid = board.forall(noDupesInRow)
    val colsValid = board.transpose.forall(noDupesInRow)

    rowsValid && colsValid && noDupesInSquares(board)
  }

  private def noDupesInSquares(board: Array[Array[Char]]): Boolean = {
    val checker = scala.collection.mutable.Set[Char]()
    // Validate Grid Property.
    for (i <- 0 until 9 by 3; j <- 0 until 9 by 3) {
      for (r <- i until i + 3; c <- j until j + 3; if (board(r)(c) != '.')) {
        if (!checker.contains(board(r)(c)))
          checker += board(r)(c)
        else return false
      }
      checker.clear
    }
    true
  }

  private def noDupesInRow(line: Array[Char]): Boolean = {
    // count how many times a digit occurs
    val allDigits = line.filter(_.isDigit)
    // count how many distinct digits we have
    val distinctDigits = allDigits.distinct
    // see if they match (no duplicates)
    allDigits.length == distinctDigits.length
  }
}

/*
G: board: Array[Array[Char]]
O: isValid: Boolean
T: O(nm)
S: O(nm)

Notes:
  - Each row must contain the digits 1-9 without repetition.
  - Each column must contain the digits 1-9 without repetition.
  - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
  - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
  - Only the filled cells need to be validated according to the mentioned rules.

Ex:

 */
