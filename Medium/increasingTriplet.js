/**
 * @param {number[]} nums
 * @return {boolean}
 */
var increasingTriplet = function(nums) {
  let low = Number.MAX_SAFE_INTEGER
  let high = Number.MAX_SAFE_INTEGER
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] < low) {
      low = nums[i]
    } else if (nums[i] > low && nums[i] < high) {
      high = nums[i]
    } else if (nums[i] > low && nums[i] > high) {
      return true
    }
  }

  return false
}
