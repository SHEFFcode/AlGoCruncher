/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
  let allValidTriplets = []
  for (let i = 0; i < nums.length - 2; i++) {
    if (i > 0 && nums[i] === nums[i - 1]) {
      continue
    }
    const numsInBetween = new Set()
    for (let j = i + 1; j < nums.length; j++) {
      if (j > 0 && nums[j] === nums[j - 1]) {
        continue
      }
      let sum = -(nums[i] + nums[j])
      if (sum === -0) sum = 0
      if (numsInBetween.has(sum)) {
        const triplet = [nums[i], sum, nums[j]]
        allValidTriplets.push(triplet)
      } else {
        numsInBetween.add(nums[j])
      }
    }
  }
  return allValidTriplets
};

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
  nums.sort((a, b) => a - b)
  let allValidTriplets = []
  for (let i = 0, len = nums.length; i < len - 2; i++) {
    if (i > 0 && nums[i] === nums[i - 1]) {
      continue
    }
    let l = i + 1
    let r = len - 1
    while (l < r) {
      let sum = nums[i] + nums[l] + nums[r]
      if (sum === 0) {
        allValidTriplets.push([nums[i], nums[l], nums[r]])
        l++
        while (l < r && nums[l] === nums[l - 1]) l++;  // skip same result
      } else if (sum > 0) {
        r--
      } else if (sum < 0) {
        l++
      }
    }
  }
  return allValidTriplets
};