/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let maxSoFar = nums[0];
    let max = nums[0];
    
    for (let i = 1; i < nums.length; i++) {
        maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
        max = Math.max(max, maxSoFar);
    }
    
    return max;
};