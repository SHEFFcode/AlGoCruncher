/**
 * The intuition is that if we can jump past the length of the array, we can jump to the end index.
 * 
 * Max Reachable = 2, 4, 4, 4, 8
 * 
 * [2,3,1,1,4]
 *          * 
 */

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int longest = 0; // let's set up the pointers
        for (int i = 0; i < n; i++) {
            if (i > longest) { // we want to break here if i is ever bigger then longest, since we got to a point we could not have reached. like this[3,2,1,0,4]
                break;
            }
            longest = Math.max(nums[i] + i, longest); // we never reduce the longest we could have jumped

        }
        return longest >= n - 1;
    }
}