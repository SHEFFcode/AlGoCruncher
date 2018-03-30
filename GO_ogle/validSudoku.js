class SudokuValidator {

  validateBoard(board) {
    return (this._rowValid(board) && this._colValid(board) && this._squareValid(board));
  }

  _rowValid(board) {
    for (let row of board) {
      if (!this._unitValid(row)) {
        return false;
      }
    }
    return true;
  }

  _colValid(board) {
    for (let j = 0; j < board.length; j++) {
      let unit = [];
      for (let i = 0; i < board[0].length; i++) {
        unit[i] = board[i][j];
      }
      if (!this._unitValid(unit)) {
        return false;
      }
    }
    return true;
  }

  _squareValid(board) {
    for (let i = 0; i < board.length - 2; i += 3) {
      for (let j = 0; j < board[0].length - 2; j += 3) {
        let start = [i, j];
        let end = [i + 3, j + 3];
        let unit = this._createSquareUnit(start, end, board);
        if (!this._unitValid(unit)) {
          return false;
        }
      }
    }
    return true;
  }

  _createSquareUnit(start, end, board) {
    let unit = [];
    for (let i = start[0]; i < end[0]; i++) {
      for (let j = start[1]; j < end[1]; j++) {
        unit.push(board[i][j]);
      }
    }
    return unit;
  }

  _unitValid(unit) {
    let checkUnit = [];
    for (let i = 0; i < unit.length; i++) {
      if (unit[i] !== '.') {
        checkUnit.push(unit[i]);
      }
    }
    let unitSet = new Set(checkUnit);
    return checkUnit.length === unitSet.size;
  }
}

/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    let sudokuValidator = new SudokuValidator();
    return sudokuValidator.validateBoard(board);
};

isValidSudoku([[".","8","7","6","5","4","3","2","1"],["2",".",".",".",".",".",".",".","."],["3",".",".",".",".",".",".",".","."],["4",".",".",".",".",".",".",".","."],["5",".",".",".",".",".",".",".","."],["6",".",".",".",".",".",".",".","."],["7",".",".",".",".",".",".",".","."],["8",".",".",".",".",".",".",".","."],["9",".",".",".",".",".",".",".","."]]
);