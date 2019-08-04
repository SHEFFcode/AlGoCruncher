class Solution {
  public int maxProduct(int[] nums) {
    if (nums.length < 2) {
      return nums[0];
    }
    int maxProd = nums[0];

    int maxPositive = nums[0];
    int maxNegative = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int self = nums[i];
      int maxCopy = maxPositive;
      maxPositive = Math.max(Math.max(self, maxPositive * self), maxNegative * self);
      maxNegative = Math.min(Math.min(self, maxNegative * self), maxCopy * self);
      maxProd = Math.max(maxPositive, maxProd);
    }

    return maxProd;
  }
}