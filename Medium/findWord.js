// A R I D S
// W E R O D
// U E F B E
// B E R E E

// 1. Horizontallly or vertically
// 2. One step at a time
// 3. No wrap around
// 4. Start from any position
// Given a letter grid and a word "UBER", return a boolean indicates if the word can be found in the grid.
//  *

console.log(findWord([
  ['A', 'R', 'I', 'D', 'S'],
  ['W', 'E', 'R', 'O', 'D'],
  ['U', 'E', 'F', 'B', 'E'],
  ['B', 'E', 'R', 'E', 'E']
], "UBER"));

function findWord(matrix, word) {
  if (_inputValid(matrix, word)) {
    for (let i = 0; i < matrix.length; i++) {
      for (let j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] === word[0]) {
          if (_traverse(i, j, 0, word, matrix) === true) {
            return true;
          }
        }
      }
    }
  }

  return false;
}

function _traverse(i, j, index, word, matrix) {
  if (matrix[i][j] === word[index] && index === word.length - 1) {
    return true;
  } else if (matrix[i][j] !== word[index]) {
    return false;
  }

  let neighbors = _generateNeighbors(i, j, matrix.length, matrix[0].length);

  let letter = matrix[i][j];
  matrix[i][j] = '.';

  for (let neighbor of neighbors) {
    if (_traverse(neighbor[0], neighbor[1], index + 1, word, matrix)) {
      return true;
    }
  }

  matrix[i][j] = letter;
}

function _generateNeighbors(iPos, jPos, height, width) {
  let neighbors = [];

  for (let i = -1; i < 2; i++) {
    for (let j = -1; j < 2; j++) {
      if (
        ((i === -1 || i === 1) && j === 0)
        || ((j === -1 || j === 1) && i === 0)
      ) {
        if (
          i + iPos > -1 && i + iPos < height
          && j + jPos > -1 && j + jPos < width
        ) {
          neighbors.push([i + iPos, j + jPos]);
        }
      }
    }
  }

  return neighbors;
}

function _inputValid(matrix, word) {
  return (
    matrix && matrix.length > 0 
    && word && word.length > 0 
    && matrix[0].length * matrix[1].length > word.length
  );
}

