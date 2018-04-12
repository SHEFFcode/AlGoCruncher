/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
  let x = 0;
  let y = 0;
  let cache = {};
  return traverse(x, y, m - 1, n - 1, cache);
};

function traverse(x, y, goalX, goalY, cache) {
  if (x === goalX && y === goalY) {
      return 1;
  } else if (x > goalX || y > goalY) {
      return 0;
  } else {
      if (cache.hasOwnProperty(`${x},${y}`)) {
          return cache[`${x},${y}`];
      } else {
          cache[`${x},${y}`] = traverse(x + 1, y, goalX, goalY, cache) + traverse(x, y + 1, goalX, goalY, cache);
      }
      return cache[`${x},${y}`];
  }
}