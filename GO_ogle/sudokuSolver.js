class SudokuSolver {
  /**
 * SudokuSolver constructor
 * @param size 
 * @param grid
 */
  constructor(size, grid) {
    this._validNumbers = [].fill(false, 0, size - 1);
    this._nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  }


  /**
   * Returns whether or not a supplied board is valid
   * @param {number[][]} board 
   * @returns {boolean}
   */
  validateBoard(board) {
    return (this._rowValid(board) && this._colValid(board) && this._squareValid(board));
  }

  solveSudoku(grid) {
    let openSpots = this._findOpenSpots(gird);
    if (this._traverseGrid(0, openSpots, grid)) {
      return grid;
    } else {
      console.log('board cannot be filled out');
      return false;
    }
  }

  _traverseGrid(index, openSpots, grid) {
    let spot = openSpots[index];
    let validMoves = this._generateValidMoves(spot, grid);

    for (let validMove of validMoves) {
      if (this._validateBoardWithMove(validMove, spot) && index === openSpots.length - 1) {
        return true;
      } else if (this._validateBoardWithMove(validMove)) {
        return this._traverseGrid(index + 1, openSpots, grid);
      }
    }

    return false; // we traversed the whole range of valid moves and will return false
  }

  _validateBoardWithMove(validMove, spot) {
    
  }

  _generateValidMoves(spot, grid) {
    let validMoves = this._nums.slice();
    let width = grid[0].length;
    let height = grid.length;
    let i = spot[0];

    for (let j = 0; j < width; j++) {
      let moveIndex = validMoves.indexOf(grid[i][j]);

      if (!~moveIndex) {
        moveIndex.splice(moveIndex, 1);
      }
    }

    let j = spot[1];
    for (i = 0; i < height; i++) {
      let moveIndex = validMoves.indexOf(grid[i][j]);

      if (!~moveIndex) {
        moveIndex.splice(moveIndex, 1);
      }
    }

    let start = [spot[0] - spot[0] % 3, spot[1]];
    let end = [spot[0], spot[1] - spot[1] % 3];

    for (i = start[0]; i < end[0]; i++) {
      for (j = start[1]; i < end[1]; j++) {
        let moveIndex = validMoves.indexOf(grid[i][j]);

        if (!~moveIndex) {
          moveIndex.splice(moveIndex, 1);
        }
      }
    }

    return validMoves;
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
    let validNumbers = this._validNumbers.slice();
    for (let i = 0; i < unit.length; i++) {
      if (!validNumbers[unit[i]]) {
        validNumbers[unit[i]] = true;
      } else {
        return false;
      }
    }
  }
}