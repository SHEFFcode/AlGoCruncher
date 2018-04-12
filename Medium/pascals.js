/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
  if (!numRows) {
      return [];
  }
  let pascals = [];
  if (numRows >= 1) {
      pascals.push([1]);
  }
  if (numRows >= 2) {
      pascals.push([1,1]);
  }
  
  for (let i = 2; i < numRows; i++) {
      let newRow = Array(i);
      newRow[0] = 1;
      newRow[i] = 1;
      for (let j = 1; j < i; j++) {
          newRow[j] = pascals[i - 1][j - 1] + pascals[i - 1][j];
      }
      pascals.push(newRow);
  }
  
  return pascals;
};

generate(5);