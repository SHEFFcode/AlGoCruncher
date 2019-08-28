class Solution {
    int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0]; // otherwise we will return too large an 
        }
        ArrayDeque<Integer> window = new ArrayDeque<>(k); // reasonable initial size
        int[] slidingWindowMax = new int[nums.length - k + 1]; // size of our output array
        int slidingWindowIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];


            while ((window.size() > 0 && (window.peek() < current || (i >= k && window.peek() == nums[i - k])))) {
                window.pollFirst(); // let's remove items
//                window.offerLast(current);
            }

            if (window.size() == 0 || current < window.peekFirst()) {
                window.offerLast(current);
            }

            if (i >= k - 1) {
                slidingWindowMax[slidingWindowIndex++] = window.peekFirst();
            }
        }

        return slidingWindowMax;
    }
}