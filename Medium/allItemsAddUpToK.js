/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    let result = [];
    let brain = {};
    traverse(candidates, target, result, null, [], brain);
    return result;
};

function traverse(arr, k, result, item, temp, brain) {
  if (k === 0) {
    let sortedTemp = temp.slice().sort((a, b) => a - b);
    let key = JSON.stringify(sortedTemp);
    if (!brain.hasOwnProperty(key)) {
      result.push(sortedTemp);
      brain[key] = true;
    }
    return;
  } else if (k < 0) {
    temp.pop();
    return;
  }

  if (item !== null) {
    k -= item;
    if (k > -1)
      temp.push(item);
  }
  arr.forEach((number) => {
    traverse(arr, k, result, number, temp.slice(), brain);
  });
}

combinationSum([2.15, 2.75, 3.35, 3.55, 4.20, 5.80], 15.05);