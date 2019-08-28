class Solution {
    int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0]; // otherwise we will return too large an
        }
        ArrayDeque<Integer> window = new ArrayDeque<>(k); // reasonable initial size, will hold the indexes of values
        int[] slidingWindowMax = new int[nums.length - k + 1]; // size of our output array
        int slidingWindowIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            if (!window.isEmpty() && window.peekFirst() == i - k) {
                window.pollFirst();
            }

            while (!window.isEmpty() && nums[window.peekLast()] < current) {
                window.pollLast();
            }

            window.offerLast(i);

            if (i >= k - 1) {
                slidingWindowMax[slidingWindowIndex++] = nums[window.peekFirst()];
            }
        }

        return slidingWindowMax;
    }
}