class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0; // initially at zero as it is a safe value

        while (end > start) {
            int cArea = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(maxArea, cArea);
            if (height[end] > height[start]) {
                start++; // move the start closer to end to maximize the area
            } else { // even if they are equal
                end--; // move the end closer to the start to maximize the area.
            }
        }

        return maxArea;
    }
}

/**
 * Since the max area requires the longest base, we want to start wide and
 * narrow in. If the start is taller then end we want to move the end in, If the
 * end is taller then the start we want to move the start in. If they are the
 * same we will pick to move the start in.
 */