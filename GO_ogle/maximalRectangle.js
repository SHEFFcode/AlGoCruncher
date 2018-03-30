/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function (matrix) {
  if (matrix.length === 0) {
    return 0;
  }
  let maxArea = 0;
  let histogramRow = new Array(matrix[0].length).fill(0, 0, matrix[0].length);
  for (let row of matrix) {
    for (let i = 0; i < row.length; i++) {
      if (row[i] === '1') {
        histogramRow[i]++;
      } else {
        histogramRow[i] = 0;
      }
    }
    maxArea = Math.max(_maxAreaHistoram(histogramRow), maxArea);
  }
  return maxArea;
};

function _maxAreaHistoram(heights) {
  let indexStack = [],
    area = 0,
    maxArea = 0,
    topIndex = 0,
    topValue = 0;

  for (let i = 0; i <= heights.length; i++) {
    if (!(indexStack.length === 0 || heights[i] > heights[indexStack[indexStack.length - 1]])) {
      while (indexStack.length > 0
        && (heights[i] < heights[indexStack[indexStack.length - 1]] || i === heights.length)) {
        topIndex = indexStack.pop();
        topValue = heights[topIndex];
        let multiplier = indexStack.length > 0 ? i - indexStack[indexStack.length - 1] - 1 : i;
        area = topValue * (multiplier);
        if (area > maxArea) {
          maxArea = area;
        }
      }
    }

    if (i < heights.length) {
      indexStack.push(i);
    }
  }

  return maxArea;
}

// maximalRectangle([["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]])
maximalRectangle([["1"]])