/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    if (!nums || nums.length === 0) {
      return [];
    }
    let threeSumMatches = [];
    nums.sort((a, b) => a - b); // sorted in place no copy is made

    for (let i = 0; i < nums.length; i++) {
      if (i - 1 >= 0 &&  nums[i] == nums[i - 1]) continue;

      let leftPointer = i + 1;
      let rightPointer = nums.length - 1;

      while (leftPointer < rightPointer) {
        let sum = nums[i] + nums[leftPointer] + nums[rightPointer];
  
        if (sum === 0) {
          threeSumMatches.push([nums[i], nums[leftPointer], nums[rightPointer]]);
          while (leftPointer + 1 < rightPointer && nums[leftPointer] == nums[leftPointer+1])// Skip equal elements to avoid duplicates
            leftPointer++;
          while (rightPointer -1 > leftPointer && nums[rightPointer] == nums[rightPointer-1])// Skip equal elements to avoid duplicates
            rightPointer--;
          leftPointer++;
          rightPointer--;
        } else if (sum > 0) {
          rightPointer--;
        } else {
          leftPointer++;
        }
      }
    }

    return threeSumMatches;
};

console.log(threeSum([-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]));