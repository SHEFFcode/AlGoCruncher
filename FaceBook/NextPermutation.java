class Solution {
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2; // we will start here at an item just to the left of the end.

    while (i >= 0 && nums[i] >= nums[i + 1]) { // we are looking for an end to a stricly decreasing sequence.
                                               // DANGER_ZONE, decrement i
      i--; // this will land at our first decreasing number in a sequence.
    }

    if (i >= 0) { // if we ran off the end of the array, the sequence was all decreasing, which
                  // means we just need to reverse it.
      int j = nums.length - 1; // we will put this at the enf the array
      while (j >= 0 && nums[j] <= nums[i]) { // we need to find a number just bigger then the # at i, since it's sorted
                                             // we do it this way.
        j--; // let's mode left so that we keep looking for the number we are looking for.
      }

      swap(nums, i, j);
    }

    reverse(nums, i + 1);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];

    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;

    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }
}

/**
 * The key here is that a permutation at the end of exploration space is in
 * decreasing sequence. Therefore the first number that is not bigger then the
 * one before is in the process of being explored. Therefore if we swap it with
 * it's next largest number in sorted space, and reverse the sorted space we get
 * the next permutation
 * 
 * largeNumber = nums[nums.length - 1] = 3 i = nums.length - 1 = 2
 * 
 * while (nums[i] >= largestNumber) i--
 * 
 * swap(i) // swaps nums[i] with the next largest value in the rest of the array
 * 
 * reverse(arr, i, nums.length)
 * 
 * return nums
 * 
 * 1, 2, 3 i
 * 
 */