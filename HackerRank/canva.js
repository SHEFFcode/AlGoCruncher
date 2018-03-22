/*
G: Number[], Number => arr, k
O: Number => length of the longest subarray whose elements add up to k
T: Any
S: Any

[1, 2, 3], 3
 *

 */

let longestSubarray = function (array, k) {
  let windowStart = 0,
      windowEnd = 1,
      longestLength = 0;

  while (windowStart < array.length) {
    let sum = array[windowStart];
    let currentLongestLength = 1;
    while (sum + array[windowEnd] <= k) {
      sum += array[windowEnd];
      windowEnd++;
      currentLongestLength++;
    }
    if (currentLongestLength > longestLength) {
      longestLength = currentLongestLength;
    }
    windowStart++;
    windowEnd = windowStart + 1;
  }

  return longestLength;
  
}

console.log(longestSubarray([4, 3, 1, 2, 1], 4));



/*


public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int length = nums.length, sum = 0, maxSubLen = 0;
        //Using a hash map to store the sum of all the values before and include nums[i]
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < length; i++) {
            sum += nums[i];
            if(sum == k) {
                maxSubLen = Math.max(maxSubLen, i + 1);
            } else if(map.containsKey(sum - k)) {
                maxSubLen = Math.max(maxSubLen, i - map.get(sum - k));
            }
            
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxSubLen;
    }
 */

 let maxSubArrayLength = function(nums, k) {
  if (nums === null || nums.length === 0) {
    return 0;
  }

  let length = nums.length, sum = 0, maxSubLen = 0;
  let map = {};

  for (let i = 0; i < nums.length; i++) {
    sum += array[i];

    if (sum === k)  {
      maxSubArrayLength = Math.max(maxSubArrayLength, i + 1);
    } else if (map.hasOwnProperty(sum - k)) {
      maxSubArrayLength = Math.max(maxSubArrayLength, i - map[sum - k]);
    }

    if (!map.hasOwnProperty(sum)) {
      map[sum] = i;
    }
  }

  return maxSubArrayLength;
 }