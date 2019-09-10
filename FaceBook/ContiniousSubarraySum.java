class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = 0;
        IntStream.range(1, nums.length).forEach(i -> sum[i] = sum[i - 1] + nums[i]);

        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int sumFromStartToEnd = sum[end] - sum[start] + nums[start];

                if (sumFromStartToEnd == k || (k != 0 && sumFromStartToEnd % k == 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}

/**
 * Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2, 4] is a
 * continuous subarray of size 2 and sums up to 6.
 * 
 * Input: [23, 2, 6, 4, 7], k=6 Output: True Explanation: Because [23, 2, 6, 4,
 * 7] is an continuous subarray of size 5 and sums up to 42.
 * 
 * 
 * 
 * [23, 2, 4, 6, 7] k = 6 i
 * 
 * [23, 25, 29, 35, 42] i
 * 
 * 0) begin at index 1, since it is the first time we can have a sub array
 * length 2 1) is 25 % 6 == 0? no so we keep going 2) is 29 % 6 == 0? no, so
 * keep going a) is sum[i] - sum[i - 1] + nums[i - 1] % 6 == 0 || 29 - 25 + 2 %
 * 6 == 0 || is 4 + 2 % 6 == 0 || 6 % 6 == 0, return true b) is 35 - 29 + 4 = 10
 * % 6 == 0? no c) is 42 % 6 == 0 ? yes, is
 * 
 */