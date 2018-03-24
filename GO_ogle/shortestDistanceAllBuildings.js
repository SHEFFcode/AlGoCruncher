class ShortestBuilding {
  constructor() {

  }

  findShortestBuildingDistance(grid) {
    let numRows = grid.length;
    if (rows === 0) {
      return 0; // if we don't have any rows, we can't have columns
    }
    let numColumns = grid[0].length;
    let buildingCount = 0;

    for (let i = 0; i < numRows; i++) {
      for (let j = 0; j < numColumns; j++) {
        if (grid[i][j] === 1) {
          buildingCount++;
        }
      }
    }
    
    let numberOfBuildingsFromWhichLandIsReacheable = [];
    let distanceFromAllBuildingsToThatLand = [];

    for (let i = 0; i < numRows; i++) {
      for (let j = 0; j < numColumns; j++) {
        if (grid[i][j] === 1) {
          if (!this._bfs(i, j, grid, numberOfBuildingsFromWhichLandIsReacheable, distanceFromAllBuildingsToThatLand, numRows, numColumns)) {
            return -1; // if all buildings are not connected, we return -1 immediately.
          }
        }
      }
    }

  }

  _bfs(i, j, grid, numberOfBuildingsFromWhichLandIsReacheable, distanceFromAllBuildingsToThatLand, numRows, numColumns) {
    let visited = [];

    if (!visited[i]) {
      visited[i] = [];
    }

    visited[i][j] = true;

    let buildingCount = 1; // initiallize to one since we start at a building
    let distance = 0;
    let queue = [];
    queue.push([i, j]);

    while (queue.length > 0) {
      distance++;
      let levelCount = queue.length;

      let [i, j] = queue.pop();
    }
  }
}

/*
Ideas:
Do BFS from all the buildings and have the following vars:

* numberOfBuildingsFromWhichLandIsReacheable[] - counts how many times we land here as # of building from which land is reachable
* ditanceFromAllBuildingsToThatLand[] - min distance from all buildings to that land

Solution will be pick the empty land recheable from all buildings with the minimum ditanceFromAllBuildingsToThatLand

Early pruning:
* return -1 if not all buildings are connected

Video Link:
https://www.youtube.com/watch?v=8K98WexA8m8
*/