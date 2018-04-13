/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
  if (!nums || nums.length === 0 || !target) {
      return [-1, -1];
  }
  let start = -1;
  let end = -1;
  let mid = Math.floor(nums.length / 2);
  
  if (nums[mid] === target) {
      start = mid;
      end = mid;
      let i = mid - 1;
      while(i >= 0) {
          if (nums[i] === target) {
              start = i;
          } else {
              break;
          }
          i--;
      }
      let j = mid + 1;
      while (j <= nums.length - 1) {
          if (nums[j] === target) {
              end = j;
          } else {
              break
          }
          j++;
      }
  } else if (nums[mid] > target) {
      return searchRange(nums.slice(0, mid), target);
  } else if (nums[mid] < target) {
      return searchRange(nums.slice(mid + 1), target);
  }
  
  return [start, end];
  
};

console.log(searchRange([1, 2, 3], 3));