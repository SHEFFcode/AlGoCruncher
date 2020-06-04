/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function (nums, val) {
  let start = 0
  let end = nums.length // we will not do - 1 here, because it would mess with the end return statement

  while (start < end) {
    if (nums[start] === val) {
      ;[nums[start], nums[end - 1]] = [nums[end - 1], nums[start]] // we will instead do - 1 here in the access step
      end--
    } else {
      start++
    }
  }

  return end
}
