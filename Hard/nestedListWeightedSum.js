/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * function NestedInteger() {
 *
 *     Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     @return {boolean}
 *     this.isInteger = function() {
 *         ...
 *     };
 *
 *     Return the single integer that this NestedInteger holds, if it holds a single integer
 *     Return null if this NestedInteger holds a nested list
 *     @return {integer}
 *     this.getInteger = function() {
 *         ...
 *     };
 *
 *     Set this NestedInteger to hold a single integer equal to value.
 *     @return {void}
 *     this.setInteger = function(value) {
 *         ...
 *     };
 *
 *     Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
 *     @return {void}
 *     this.add = function(elem) {
 *         ...
 *     };
 *
 *     Return the nested list that this NestedInteger holds, if it holds a nested list
 *     Return null if this NestedInteger holds a single integer
 *     @return {NestedInteger[]}
 *     this.getList = function() {
 *         ...
 *     };
 * };
 */
/**
 * @param {NestedInteger[]} nestedList
 * @return {number}
 */
var depthSumInverse = function (nestedList) {

  let levelByLevelSum = [0];
  let currentLevel = 0;
  let maxLevel = [0];

  _traverse(nestedList, levelByLevelSum, 0, maxLevel);

  return levelByLevelSum.reduce((accumulator, currentValue, index) => accumulator + currentValue * (maxLevel[0] - index), 0);

};

function _traverse(nestedList, levelByLevelSum, cLevel, maxLevel) {
  if (cLevel + 1 > maxLevel[0]) {
    maxLevel[0] = cLevel + 1;
  }
  nestedList.forEach((item) => {
    if (item.isInteger()) {
      if (levelByLevelSum[cLevel]) {
        levelByLevelSum[cLevel] += item.getInteger();
      } else {
        levelByLevelSum[cLevel] = item.getInteger();
      }
    } else {
      _traverse(item.getList(), levelByLevelSum, cLevel + 1, maxLevel);
    }
  });
}