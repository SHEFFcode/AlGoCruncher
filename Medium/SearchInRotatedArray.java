/**
 * Try to find 0
 * [0,1,2,4,5,6,7] => initial array
 * [4,5,6,7,0,1,2] => rotated array
 *        * 
 * |------| because 4 is smaller then 7, this is the sorted region, but obvi 0 won't be in that range, so lets look elsewhere
 *         |-----| also sorted, where the item will be.
 *             *  x is smaller then 1, so let's look left
 *          *  0 is x, so we have found what we were looking for.
 */




class Solution {
    public int search(int[] nums, int target) {
        return traverse(nums, 0, nums.length - 1, target);
        
    }

    private int traverse(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid; // we found the spot where the item is.
        }

        // if low to mid is sorted
        if (nums[low] <= nums[mid]) {
            if (target >= nums[low] && target <= nums[mid]) { // is the target between low and mid, let's search this range
                return traverse(nums, low, mid - 1, target);
            }
            return traverse(nums, mid + 1, high, target); // search the other range
        }

        // if low to mid is not sorted, then mid to end of array must be sorted
        if (target >= nums[mid] && target <= nums[high]) {
            return traverse(nums, mid + 1, high, target); // let's search the sorted section
        }

        return traverse(nums, low, mid - 1, target); // let's search the other direction.

    }
}