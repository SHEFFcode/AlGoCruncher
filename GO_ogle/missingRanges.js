/**
 * @param {number[]} nums
 * @param {number} lower
 * @param {number} upper
 * @return {string[]}
 */
var findMissingRanges = function(nums, lower, upper) {
  if (_inputValid(nums)) {
    let small = lower,
    big = upper,
    missingIntervals = [];
    nums.sort( (a, b) => a - b);

    for (var i = 0; i < nums.length; i++) {
      if (small === nums[i]) {
        small++;
      } else {
        missingIntervals.push(`${small}${nums[i] - 1 !== small ? '->' + (nums[i] - 1) : ''}`);
        small = nums[i] + 1;
      }
    }

    if (nums[i - 1] !== big) {
      missingIntervals.push(`${(nums[i - 1] || 0) + 1}${nums[i - 1] ? '->' + big : ''}`);
    }
    return missingIntervals;
  }
  return null;
}

function _inputValid(arr) {
  return !!arr;
}

console.log(findMissingRanges([0, 1, 2, 4, 50], 0, 99));