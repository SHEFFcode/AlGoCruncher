object Solution {
    def exist(board: Array[Array[Char]], word: String): Boolean = {
      for {
        i <- 0 to board.length
        j <- 0 to board(0).length
      } yield {
        if (exists(board, i, j, word, 0)) return true
      }
      false
    }

    def exists(board: Array[Array[Char]], i: Int, j: Int, word: String, wIndex: Int): Boolean = {
      if (wIndex == word.length) return true
      if (i < 0 || j < 0 || (i == board.length) || (j == board(i).length)) return false
      if (board(i)(j) != word(wIndex)) return false
      val temp = board(i)(j)
      board(i)(j) = '.'
      val nextWIndex = wIndex + 1
      val wordExists =
        exists(board, i, j + 1, word, nextWIndex) ||
        exists(board, i, j - 1, word, nextWIndex) ||
        exists(board, i + 1, j, word, nextWIndex) ||
        exists(board, i - 1, j, word, nextWIndex)
      board(i)(j) = temp
      wordExists
    }
  }