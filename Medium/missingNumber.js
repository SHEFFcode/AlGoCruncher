/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
  let n = nums.length;
  let sum = n * (n + 1) / 2; // see math formula for factorial addition
  let diff = sum - nums.reduce((accumulator, item) => accumulator + item);
  return diff;
};
/*
Math forumalte for factorial addition.
http://mathforum.org/library/drmath/view/61212.html
 */