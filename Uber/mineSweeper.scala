object Solution {
  private type Grid = Array[Array[Char]]
  private val MINE = 'M'
  private val REVEALED_MINE = 'X'
  private val EMPTY_SQUARE = 'E'
  private val REVEALED_EMPTY_SQUARE = 'B'
  private val DIRS =
    Array((1, 1), (-1, -1), (-1, 1), (1, -1), (1, 0), (0, 1), (-1, 0), (0, -1))
  private val TOP = Array((-1, -1), (-1, 0), (-1, 1))
  private val ROW = Array((0, -1), (0, 1))
  private val BOTTOM = Array((1, -1), (1, 0), (1, 1))
  private type Dirs = Array[(Int, Int)]
  def updateBoard(
      board: Array[Array[Char]],
      click: Array[Int]
  ): Array[Array[Char]] = {
    val Array(x, y) = click
    traverse(board, x, y)
    board
  }

  private def traverse(board: Grid, x: Int, y: Int): Unit = {
    if (!valid(board, x, y)) return
    val cell = board(x)(y)
    if (cell == MINE) {
      board(x)(y) = REVEALED_MINE
    } else if (cell == REVEALED_MINE || cell.isDigit) {
      return
    } else if (diagonalBomb(board, x, y) > 0) {
      return
    } else if (cell == EMPTY_SQUARE) {
      board(x)(y) = REVEALED_EMPTY_SQUARE
      for ((x1, y1) <- DIRS) {
        traverse(board, x + x1, y + y1)
      }
    }
  }

  private def diagonalBomb(board: Grid, x: Int, y: Int): Int = {
    val bombsAround = Array(TOP, ROW, BOTTOM).foldLeft(0) {
      case (bombs, dirs) => bombs + calculateBombs(dirs, board, x, y)
    }
    if (bombsAround > 0) {
      val bombsAsChar = s"${bombsAround}".toCharArray().head
      board(x)(y) = bombsAsChar
    }

    bombsAround
  }

  private def calculateBombs(dirs: Dirs, board: Grid, x: Int, y: Int): Int = {
    dirs.foldLeft(0) {
      case (count, (x1, y1)) => {
        val (xNxt, yNxt) = (x + x1, y + y1)
        if (valid(board, xNxt, yNxt)) {
          if (board(xNxt)(yNxt) == MINE) count + 1 else count
        } else count
      }
    }
  }

  private def valid(board: Grid, x: Int, y: Int): Boolean = {
    x > -1 && y > -1 && x < board.length && y < board.head.length
  }
}

/*
G: board: Array[Array[Char]] , click: Array[Int]
O: openedBoard: Array[Array[Char]]
T: O(nm)
S: O(nm)

Notes:
  - You are given a 2D char matrix representing the game board.
  - 'M' represents an unrevealed mine,
  - 'E' represents an unrevealed empty square,
  - 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines,
  - digit ('1' to '8') represents how many mines are adjacent to this revealed square,
  - and finally 'X' represents a revealed mine.
  - Rules:
    ^ If a mine ('M') is revealed, then the game is over - change it to 'X'.
    ^ If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
    ^ If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
    ^ Return the board when no more squares will be revealed.

Ex:

 */
