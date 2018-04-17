/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
  if (!matrix || matrix.length === 0) {
      return 0;
  }
let row = Array(matrix[0].length).fill(0);
let maxArea = 0;

for (let i = 0; i < matrix.length; i++) {
  let extraRow = matrix[i];
  for (let j = 0; j < matrix[0].length; j++) {
    if (extraRow[j] == 0) {
      row[j] = 0;
    } else {
      row[j] += parseInt(extraRow[j]);
    }
  }
  cArea = _calculateMaxAreaHistogram(row, maxArea)
  if (cArea > maxArea) {
    maxArea = cArea;
  }
}

return maxArea;
};

function _calculateMaxAreaHistogram(row, maxArea) {
let stack = [];
let cArea = 0;
let startIndex = 0;


for (let index = 0; index < row.length; index++) {
  height = row[index];
  if (row[index] >= row[startIndex]) {
    startIndex = index;
  }
  if (index === row.length - 1) {
    cArea = height * (index -  (startIndex - 1) || 1);
    if (cArea > maxArea) {
      return cArea;
    }
  }
  if (height >= row[stack[stack.length - 1]] || stack.length === 0) {
    stack.push(index);
  } else {
    let len = stack.pop();
    cArea = row[len] * (index - len);
    if (cArea > maxArea) {
      maxArea = cArea;
    }
    while (height < row[stack[stack.length - 1]]) {
      len = stack.pop();
      cArea = height * (index - len - 1);
      if (cArea > maxArea) {
        maxArea = cArea;
      }
    }
  }
}
return maxArea;
}

// maximalRectangle([["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]);
maximalRectangle([["1","1"]]);

