class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> allNumbers = new ArrayList<>();
        for (int v : nums)
            allNumbers.add((double) v);
        return solve(allNumbers);
    }

    private boolean solve(List<Double> nums) {
        // BASE CASE CONDITION: we either get a number 24 after all bifunction ops (applied to all 4 numbers will reduce to a single value) or we dont
        if (nums.size() == 0)
            return false; // we have used up all the numbers
        if (nums.size() == 1)
            return Math.abs(nums.get(0) - 24) < 1e-6; // we are down to our last number, let's see if it meets our criteria

        // on the second iteration here, we will see an array of 3 nums instead of 4, where the 3d num is the result of ops on i and j previousely, and other other 2 are the 2 non i and j numbers we picked prior
        // therefore, here we will conduct our ops between two original numbers and the result of operations on the other 2
        // later we will go down to 2 numbers, result of two other ops on sums
        // finally we will get to 1 number, where we will either get a 24 or not. If we get to 0 numbers somehow, let's return false
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) { // don't do anything when i and j are the same, we want to pick two diff numbers to work with

                    List<Double> numsWithOp = new ArrayList<>(); // let's make a two number container

                    // CHOOSE: unmodified nums
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) { // this will initially populate the two numbers that are not at i and j, these remain as is, and we will apply a combinator function for to i and j
                            numsWithOp.add(nums.get(k));
                        }
                    }

                    // CHOOSE: 2 nums with one of 4 bifunction combiner ops applied
                    for (int k = 0; k < 4; k++) { // these are the 4 signs we will use the apply combine operation to nums at i and j
                        if (k < 2 && j > i)
                            continue; // because there is no difference in commutative operations, let's not double up in our decision space here

                        if (k == 0) {
                            numsWithOp.add(nums.get(i) + nums.get(j)); // let's add to the original 2 numbers the result of adding the other 2 numbers numbers at i and j
                        }
                        if (k == 1) {
                            numsWithOp.add(nums.get(i) * nums.get(j)); // let's add to the original 2 numbers the result of  multiplying the other 2 numbers at i and j
                        }

                        // subtraction is not a commutative operation, so it matters whether we do nums[i] - nums[j] vs nums[j] - nums[i] and nums[i] / nums[j] vs nums[j] / nums[i]
                        if (k == 2) {
                            numsWithOp.add(nums.get(i) - nums.get(j)); //let's add to the original 2 numbers the result of subtracting numbers i and j
                        }

                        // below operation I cannot do if j > i without producing a zero which is a useless result
                        if (k == 3) {
                            if (nums.get(j) != 0) { // division, so let's be even more careful here
                                numsWithOp.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }

                        // EXPLORE
                        if (solve(numsWithOp)) {
                            return true;
                        }

                        // UNCHOOSE: remove the last item, which is the result of bifunction combiner
                        numsWithOp.remove(numsWithOp.size() - 1); // we will remove the last element here, which is the result of the operations block above.
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