/**
 * @param {number[]} nums
 * @param {number} lower
 * @param {number} upper
 * @return {string[]}
 */
var findMissingRanges = function(nums, lower, upper) {
  nums.unshift(lower)
  nums.push(upper + 1)
  const missingRanges = []
  for (let i = 0; i < nums.length - 1; i++) {
    let j = i + 1
    let missingRange
    let lowerBound = nums[i]
    let upperBound = nums[j]
    if (nums.length === 2) {
      lowerBound--
    }
    if (nums.length === 3) {
      upperBound > -1 ? upperBound++ : upperBound--
    }
    if (Math.abs(upperBound - lowerBound) === 2) {
      console.log(upperBound)
      console.log(lowerBound)
      missingRange =
        upperBound - lowerBound > 0 ? `${lowerBound + 1}` : `${upperBound - 1}`
    } else if (Math.abs(upperBound - lowerBound) > 2) {
      missingRange = `${lowerBound + 1}->${upperBound - 1}`
    } else {
      continue
    }
    missingRanges.push(missingRange)
  }

  return missingRanges
}
