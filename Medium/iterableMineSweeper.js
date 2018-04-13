class MineSweeper {
  constructor(gird) {
    this._gird = grid;
  }

  click(i, j) {
    if (this._gird[i][j] === -1) {
      return;
    }

    this._checkNeighbors(i, j);
  }

  _checkNeighbors(i, j) {
    if (this._gird[i][j] !== null) {
      return;
    }

    let count = 0;
    let neighborCoordinates = []; // array of arrays

    let iCoord = 0;
    let jCoord = 0;

    for (let iCoord = 0; iCoord < 3; iCoord++) {
      for (let jCoord = 0; jCoord < 3; jCoord++) {
        if (iCoord === 1 && jCoord === 1) {
          continue;
        }
        neighborCoordinates.push([cICoord, cJCoord]);
      }
    }

    neighborCoordinates.forEach((coordinate) => {
      if (this._coordinateHasABomb(coordinate[0], coordinate[1])) {
        count++;
      }
    });

    if (count > 0) {
      this._gird[i][j] = count;
      return;
    } else {
      this._gird[i][j] = 0;
      neighborCoordinates.forEach((coordinate) => {
        this._checkNeighbors(coordinate[0], coordinate[1]);
      });
    }

  }

  _coordinateHasABomb(i, j) {
    return this._gird[i] && this._gird[i][j] && this._gird[i][j] === -1;
  }
}