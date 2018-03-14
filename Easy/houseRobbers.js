/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let brain = {};
    
    for (var i = 0; i < nums.length; i++) {
        if (i === 0) {
            brain[i] = nums[i];
        } else if (i === 1) {
            brain[i] = Math.max(nums[i], brain[i - 1]);
        } else {
            brain[i] = Math.max(nums[i] + brain[i - 2], brain[i - 1]);
        }
    }
    
    return brain[i - 1] ? brain[i - 1] : 0; // we will want to decrement i after it has been incremented above.
};