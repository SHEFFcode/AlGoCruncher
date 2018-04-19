/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function(nums) {
    let startR = null;
    let endR = null;
    let result = [];

    for (let i = 0; i < nums.length; i++) {
      if (startR === null) {
        startR = nums[i];
      }
      endR = nums[i];

      if (nums[i + 1] !== endR + 1 || i === nums.length - 1) {
        if (startR !== endR) {
          result.push(`${startR}->${endR}`);
        } else {
          result.push(startR.toString());
        }
        startR = null;
        endR = null;
      }
    }

    return result;
};

summaryRanges([0,1,2,4,5,7]);