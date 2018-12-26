object Solution {
    def exist(board: Array[Array[Char]], word: String): Boolean = {
        for {
          i <- board
          j <- board[i]
        } yield {
          def recurse(i: Int, j: Int, board: Array[Array[Char]], word: String, index: Int): Option[Boolean] = {
            if (board(i)(j) == word(index)) {
              val temp = board(j)(j)
              board(i)(j) = '.'
              val newIndex = index + 1
              val result = recurse(i + 1, j, board, word, newIndex).orElse(false) || recurse(i - 1, j, board, word, newIndex).orElse(false)
              || recurse(i, j + 1, board, word, newIndex).orElse(false) || recurse(i, j - 1, board, word, newIndex).orElse(false)
              board(i)(j) = temp
              result
            }
            else false
          }
          recurse(i, j, board, word, 0)
        }
    }
}