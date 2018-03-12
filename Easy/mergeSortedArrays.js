/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
	while (m > 0 && n > 0) {
		if (nums1[m - 1] >= nums2[n - 1]) {
			nums1[m + n - 1] = nums1[m - 1];
			m--;
		} else {
			nums1[m + n - 1] = nums2[n - 1];
			n--;
		}
	}

	if (n > 0) {
		nums1.splice(0, n, ...nums2.slice(0, n));
	}
}

/*
G: int[] nums1, int[] nums2
O: int[] sortedArray
T: O(n)
S: O(1)

Notes:
* nums1 has enough space to hold both arrays, so you do not need to create additional space
* can array be empty?
* can array contain non integer input?
* can array contain same values, and if so how do we sort them

Case1: nums1[item] > nums2[item]:
	nums1.splice(item, 0, nums2[item]);
	move array2 pointer forward
Case2: nums1[item] <= nums2[item]:
	do nothing, just move up the array 1 pointer forward
Case3: end of nums1:
	nums1.push(...nums2)
Case4: end of nums2:
	break
*/


