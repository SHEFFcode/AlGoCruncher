/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
    /*
      G: 2 integer arrays
      O: Find their intersection
      T: Any
      S: Any

      Notes:
      * Each element in the result should appear as many times as it does in the original
      * Result can be in any order
      
      Follow Up:
      * What if the array was already sorted, how would you optimize your algo? => Already did.
      * What if size of one arrays is significantly smaller then the size of the other array?
      * What if elements of nums two are stored to disk?
      
      Solution:
      [1, 2, 2, 1]  [2, 2]  => [2, 2]
      
      i: [1, 2, 2, 1]  [2, 2] => sort()
      1: [1, 1, 2, 2]  [2, 2] => We keep moving the pointer forward until we hit the same numbers in both arrays
                *       ^
      2: [1, 1, 2, 2]  [2, 2] => We keep moving the pointer forward in both arrays for as long as they match, or until they run out of items.
                   *       ^
    */

    nums1.sort((a, b) => a - b);
    nums2.sort((a, b) => a - b);
    let intersectionArray = [];

    let i = 0, j = 0;  // init the iteration variables

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] === nums[j]) {
        intersectionArray.push(nums[i]);
        i++, j++;  // we want to advance the pointer
      } else if (nums[i] < nums[j]) {
        i++;
      } else {
        j++;
      }
    }

    return intersectionArray;
};