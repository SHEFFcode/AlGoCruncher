class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums); // if we have a sorted array it will be a lot easier to skip the duplicate
                           // number permutations.

        traverseWithBacktracking(result, nums, new ArrayList<>(), new boolean[nums.length]);

        return result;
    }

    private void traverseWithBacktracking(List<List<Integer>> result, int[] nums, List<Integer> currentRow,
            boolean[] alreadyPickedAtIndex) {

        if (currentRow.size() == nums.length) {

            result.add(new ArrayList(currentRow)); // might be a way to optimize here, GOAL

        } else {

            for (int i = 0; i < nums.length; i++) {
                /**
                 * let's see if we already picked a number at index, or if the current number
                 * equals to a previous number (it's a duplicate) and we did not pick the
                 * previous number, meaning we want to skip all the subsequent duplicates of
                 * that number as well
                 */

                if (alreadyPickedAtIndex[i] || i > 0 && nums[i] == nums[i - 1] && !alreadyPickedAtIndex[i - 1]) {
                    continue; // CONSTRAINTS
                }

                // Choose
                alreadyPickedAtIndex[i] = true;
                currentRow.add(nums[i]);

                // Explore
                traverseWithBacktracking(result, nums, currentRow, alreadyPickedAtIndex);

                // Unchoose
                alreadyPickedAtIndex[i] = false;
                currentRow.remove(currentRow.size() - 1);
            }
        }
    }
}

/**
 * 
 * 
 * 
 * Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ] *
 * 
 * 112 / | \ 1 1 2 / | 11 12 21 / | 112 121 211
 * 
 * 
 */