class Solution {
  public int lengthOfLIS(int[] nums) {
    int longestLIS = 0;
    int currentLIS = 0;
    int previousNumber = 0;

    for (int i = 0; i < nums.length; i++) {
      currentLIS = 1; // reset at every turn of the outer loop
      previousNumber = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        if (previousNumber < nums[j]) {
          currentLIS++;
          previousNumber = nums[j];
        }
      }
      longestLIS = Math.max(currentLIS, longestLIS);
    }

    return longestLIS;
  }
}