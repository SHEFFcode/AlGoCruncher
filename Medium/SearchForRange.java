class Solution {
    private int searchFirst(int[] nums, int low, int high, int x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ( 
                (mid == 0 || x > nums[mid - 1])
                && nums[mid] == x
            ) { // we found the first x in the array
                return mid;
            } else if (x > nums[mid]) { // if x is bigger, we undershot the first x, we gotta search right
                return searchFirst(nums, mid + 1, high, x);
            } else { // we overshot the first x, we gotta search left
                return searchFirst(nums, low, mid - 1, x);
            }
        }
        return -1;
    }
    private int searchLast(int[] nums, int low, int high, int x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (
                (mid == nums.length - 1 || x < nums[mid + 1])
                && nums[mid] == x
            ) { // we found the last x in the array
                return mid;
            } else if (x < nums[mid]) { // we overshot the last x, we gotta search left
                return searchLast(nums, low, mid - 1, x);
            } else { // we overshot the last x, we gotta search right
                return searchLast(nums, mid + 1, nums.length - 1, x);
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[] {
            searchFirst(nums, 0, nums.length - 1, target),
            searchLast(nums, 0, nums.length - 1, target)
        };
    }
}