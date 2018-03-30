class SudokuValidator {
  /**
   * SudokuValidator constructor
   * @param size 
   */
  constructor(size) {
    this.validNumbers = [].fill(false, 0, size - 1);
  }


  /**
   * Returns whether or not a supplied board is valid
   * @param {number[][]} board 
   * @returns {boolean}
   */
  validateBoard(board) {
    return (this._rowValid(board) && this._colValid(board) && this._squareValid(board));
  }

  /**
   * Private method to check row validity
   * @param {number[][]} board 
   * @returns {boolean}
   */
  _rowValid(board) {
    for (let row of board) {
      if (!this._unitValid(row)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Private method to check column validity
   * @param {number[][]} board 
   * @returns {boolean}
   */
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

  /**
   * Checks whether each individual 3x3 square is valid
   * @param {number[][]} board 
   * @returns {boolean}
   */
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

  /**
   * Method to generate a nice flat array out of a 3x3 square
   * @param {number[]} start 
   * @param {number[]} end 
   * @param {number[][]} board
   * @returns {number[]}
   */
  _createSquareUnit(start, end, board) {
    let unit = [];
    for (let i = start[0]; i < end[0]; i++) {
      for (let j = start[1]; j < end[1]; j++) {
        unit.push(board[i][j]);
      }
    }
    return unit;
  }

  /**
   * Checks whether a provided generic unit is valid
   * @param {number[]} unit 
   * @returns {boolean}
   */
  _unitValid(unit) {
    let validNumbers = this.validNumbers.slice();
    for (let i = 0; i < unit.length; i++) {
      if (!validNumbers[unit[i]]) {
        validNumbers[unit[i]] = true;
      } else {
        return false;
      }
    }
  }
}