class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 2) {
      return nums[0] == nums[1] ? 1 : 2;
    }

    int i = 0, j = 1;

    for (; j < nums.length; j++) {
      if (nums[i] != nums[j] && j - i == 1) {
        i++;
      } else if (nums[i] != nums[j]) {
        nums[i + 1] = nums[j];
        i++;
      }
    }

    return i + 1;
  }
}

/**
 * given: [1, 1, 2] => 2 i j
 * 
 * i + 1 would equal nums[j], then increment i to i + 2
 * 
 * [0, 1, 2, 3, 4, 2, 2, 3, 3, 4] i j
 * 
 * 
 * 
 * [0, 1, 2, 3, 4, 2, 2, 3, 3, 4] i j
 * 
 * 
 * if nums[i] != nums[j] && j - i == 1 i++, j++
 * 
 * else if (nums[i] != nums[j]) nums[i + 1] = nums[j] i = ++ j++
 * 
 * else if (nums[i] == nums[j]) j++
 * 
 * 
 */