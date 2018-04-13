/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
  let neededLetter = word[0];
  let foundWord = false;
  let visited = {};

  for (let i = 0; i < board.length; i++) {
    if (foundWord) {
      break;
    }
    for (let j = 0; j < board[0].length; j++) {
      if (board[i][j] === neededLetter) {
        visited[`${i},${j}`] = true;
        foundWord = _backtrackingCheckNeighbors(i, j, 1, word, board, visited);
        if (foundWord) {
          break;
        }
        visited = {};
      }
    }
  }

  return foundWord;
};

function _backtrackingCheckNeighbors(iPos, jPos, letterIndex, word, board, visited) {
  if (letterIndex === word.length) {
    return true;
  }

  let surroundingGrid = [];
  let foundLetter = false
  let values = [-1, 0, 1];

  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      if (i === 1 && j === 1 || i === 0 && j === 0 || i === 2 && j === 2 || i === 0 && j === 2 || i === 2 && j === 0) {
        continue;
      }
      surroundingGrid.push([iPos + values[i], jPos + values[j]]);
    }
  }

  for (let k = 0; k < surroundingGrid.length; k++) {
    let point = surroundingGrid[k];
    if (point[0] >= 0 && point[0] < board.length && point[1] >= 0 && point[1] < board[0].length) {
      if (board[point[0]][point[1]] === word[letterIndex]) {
        if (!visited[`${point[0]},${point[1]}`]) {
          visited[`${point[0]},${point[1]}`] = true;
          foundLetter = _backtrackingCheckNeighbors(point[0], point[1], letterIndex + 1, word, board, visited);
          if (foundLetter) {
            break;
          }
        }
      }
    }
  }
    delete visited[`${iPos},${jPos}`]
    return foundLetter;
}