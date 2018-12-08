import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentLevel = new ArrayList<>();
    generateSubsets(nums, 0, currentLevel, result);

    return result;
  }

  protected void generateSubsets(int[] nums, int currentIndex, List<Integer> currentLevel, List<List<Integer>> result) {
    if (currentIndex == nums.length) {
      result.add(currentLevel); // we are done with cLevel
      return;
    }

    int num = nums[currentIndex++]; // number at current index that we need to add to other levels
                                    // also increment the index after access
    List<Integer> newLevel = new ArrayList<>(currentLevel); // create a new level from current level
    newLevel.add(num); // add current number to new level

    generateSubsets(nums, currentIndex, newLevel, result); // generate super sets from the new level
    generateSubsets(nums, currentIndex, currentLevel, result); // continue to generate super sets with current level
  }
}