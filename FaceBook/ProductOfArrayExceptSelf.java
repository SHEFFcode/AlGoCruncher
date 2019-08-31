import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] output = new int[nums.length];
    Arrays.fill(output, 1);

    IntStream.range(0, nums.length).reduce(1, (a, i) -> {
      output[i] *= a;
      return a * nums[i];
    });

    IntStream.range(0, nums.length).reduce(1, (a, i) -> {
      output[nums.length - 1 - i] *= a;
      return a * nums[nums.length - 1 - i];
    });

    return output;
  }
}

/**
 * The key here is to realize that since we cannot use division, we have to
 * concoct a way to mutliply a number of all numbers to its right and all
 * numbers to its left without the number itself. So what we will do is go left
 * to right and right to left with an accumulator, and populate the spots in the
 * output array with product of what's already in output times what the current
 * accumulated product is.
 * 
 */