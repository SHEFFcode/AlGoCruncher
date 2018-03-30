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
        let start = small;
        let end;
        let end = nums[i] - 1 !== small ? '->' + (nums[i] - 1) : '';
        missingIntervals.push(`${start}${end}`);
        small = nums[i] + 1;
      }
    }

    if (nums[i - 1] !== big) {
      let start = (nums[i - 1] + 1 || small);
      let end = nums[i - 1] && Math.abs(upper - lower) > 1 ? '->' + big : '';
      missingIntervals.push(`${start}${end}`);
    }
    return missingIntervals;
  }
  return null;
}

function _inputValid(arr) {
  return !!arr;
}

console.log(findMissingRanges([], -3, -1));