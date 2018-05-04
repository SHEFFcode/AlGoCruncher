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
  if (_inputValid(matrix, word)) { //TODO: code up the validation function
    for (let i = 0; i < matrix.length; i++) {
      for (let j = 0; j < matrix[0].length; j++) {
        if (_traverse(i, j, 0, word, matrix)) {
          return true;
        }
      }
    }
  }

  return false;
}

function _traverse(i, j, wordIndex, word, matrix) {
  if (wordIndex === word.length - 1) {
    return (matrix[i][j] === word[wordIndex]);
  }

  

  if (matrix[i][j] !== word[wordIndex]) {
    return false;
  }

  let letter = matrix[i][j];
  matrix[i][j] = '.';

  let neighbors = _generateNeighbors(i, j, matrix.length, matrix[0].length); //[[i, j], [i, j]]

  for (let neigbor of neighbors) {
    if (_traverse(neigbor[0], neigbor[1], wordIndex + 1, word, matrix)) {
      return true;
    }
  }
  matrix[i][j] = letter;
}

function _generateNeighbors(iPos, jPos, height, width) {
  let neighbors = [];

  for (let i = -1; i < 2; i++) {
    for (let j = -1; j < 2; j++) {
      if ((i === -1 || i === 1) && j === 0
        || i === 0 && (j === -1 || j === 1)) {
        if (iPos + i > -1 && jPos + j > -1 && iPos + i < height && jPos + j < width) {
          neighbors.push([iPos + i, jPos + j]);
        }

      }
    }
  }

  return neighbors;
}

function _inputValid(matrix, word) {
  return matrix && word && matrix.length > 0 && word.length > 0 && matrix[0].length * matrix[1].length > word.length
}

