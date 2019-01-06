class Solution {
    public int findPeakElement(int[] nums) {
        return findPeakElIndex(0, nums.length - 1, nums);
    }

    private int findPeakElIndex(int start, int end, int[] nums) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        System.out.println(mid);

        // Compare middle element with its neighbours (if neighbours exist)
        if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] <= nums[mid]))
            return mid;

        // If middle element is not peak and its left neighbour is greater
        // than it, then left half must have a peak element
        else if (mid > 0 && nums[mid - 1] > nums[mid])
            return findPeakElIndex(start, mid - 1, nums);

        // If middle element is not peak and its right neighbour is greater
        // than it, then right half must have a peak element
        else
            return findPeakElIndex(mid + 1, end, nums);
    }
}