/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
  let len = nums.length;
  nums.sort((a, b) => a - b);
  for (let i = 0; i < nums.length; i++) {
      if (nums[i] === val) {
          len--;
          nums[i] = Number.MAX_SAFE_INTEGER;
      }
  }
  
  nums.sort((a, b) => a - b);
  
  return len;
};