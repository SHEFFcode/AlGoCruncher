/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxSubArrayLen = function (nums, k) {
  let subarrayLength = 0,
    sum = 0,
    map = {0: -1};

  nums.forEach((number, i) => {
    sum += number;
    if (!map.hasOwnProperty(sum)) {
      map[sum] = i;
    }

    if (map.hasOwnProperty(sum - k)) {
      subarrayLength = Math.max(subarrayLength, i - map[sum - k]);
    }
  });

  return subarrayLength;
};

maxSubArrayLen([-2,1,-3,4,-1,2,1,-5,4], 6)