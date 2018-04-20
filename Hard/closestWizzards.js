const wizzards = [
  [1, 8, 6],
  [2, 3],
  [5, 2],
  [4, 6],
  [5, 8],
  [6, 9],
  [7, 9],
  [8, 9],
  [1],
  [1, 3]
];

function findMinPath(wizzards, start = 0, goal = 9) {
  let shortestPathArr = [],
    shortestPathLen = Number.MAX_SAFE_INTEGER,
    brain = {},
    currentWizzardFriends = wizzards[start];

  for (let i = 0; i < currentWizzardFriends.length; i++) {
    let currentShortestPathArr = [0];
    let currentShortestPathLen = 0;
    _traverse(currentWizzardFriends[i], 0, currentShortestPathArr, currentShortestPathLen);
  }

  function _traverse(currentWizzard, previousWizzard, currentShortestPathArr, currentShortestPathLen) {
    currentShortestPathArr.push(currentWizzard);
    currentShortestPathLen += Math.pow(currentWizzard - previousWizzard, 2);

    if (currentWizzard === goal) {
      if (currentShortestPathLen < shortestPathLen) {
        shortestPathLen = currentShortestPathLen;
        shortestPathArr = currentShortestPathArr.slice();
        currentShortestPathArr.pop();
        return;
      }
    }

    let currentWizzardFriends = wizzards[currentWizzard];

    for (let i = 0; i < currentWizzardFriends.length; i++) {
      if (brain.hasOwnProperty(`${currentWizzard},${i}`)) {
        continue;
      }
      brain[`${currentWizzard},${i}`] = true;
      _traverse(currentWizzardFriends[i], currentWizzard, currentShortestPathArr.slice(), currentShortestPathLen);
    }
  }

  return shortestPathArr;
}

findMinPath(wizzards, 0, 9);