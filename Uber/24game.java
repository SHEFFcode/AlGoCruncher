class Solution {
    public boolean judgePoint24(int[] nums) {
        List allNumbers = new ArrayList<Double>();
        for (int v: nums) allNumbers.add((double) v);
        return solve(allNumbers);
    }
    private boolean solve(ArrayList<Double> nums) {
        if (nums.size() == 0) return false; // we have used up all the numbers
        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6; // we are down to our last number, let's see if it meets our criteria

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<Double>();
                    for (int k = 0; k < nums.size(); k++) if (k != i && k != j) {
                        nums2.add(nums.get(k));
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0) nums2.add(nums.get(i) + nums.get(j));
                        if (k == 1) nums2.add(nums.get(i) * nums.get(j));
                        if (k == 2) nums2.add(nums.get(i) - nums.get(j));
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(nums2)) return true;
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}

/**
 *  Input: [4, 1, 8, 7]
 *  You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.        
    Output: True
    Explanation: (8-4) * (7-1) = 24

    4, 1, 8, 7

    4 *
    4 /
    4 +
    4 -
    

    - (
    + (
    * (
    / (

    This looks like a decision space explroation algorithm, so we will try recursion with backtracking, which needs:
        * Base case, when we got to the result, which is basically 24
        * Choose, explore, unchoose
 */