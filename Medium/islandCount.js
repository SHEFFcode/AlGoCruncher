/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
  let islandCount = 0;
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (grid[i][j] == 1) {
        islandCount++;
        traverseGrid(grid, i, j);
      }
    }
  }
  return islandCount;
};

var traverseGrid = function (grid, i, j) {
  if (grid[i][j] == 1) {
    grid[i][j] = -1;
    if (grid[i][j + 1]) {
      traverseGrid(grid, i, j + 1);
    }
    if (grid[i + 1] && grid[i + 1][j]) {
      traverseGrid(grid, i + 1, j);
    }
    if (grid[i][j - 1]) {
      traverseGrid(grid, i, j - 1);
    }
    if (grid[i - 1] && grid[i - 1][j]) {
      traverseGrid(grid, i - 1, j);
    }
  }
}

console.log(numIslands([["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]))