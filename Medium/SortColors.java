/**
 * Input: [0,0,1,1,2,2]
 *             r
 *                 w   
 *               b
 * 
 * 
 * Output: [0,0,1,1,2,2]
 * 
 * 
 * 
 * 
 * 
 */

class Solution {
    public void sortColors(int[] nums) {
        int r = 0, b = nums.length - 1; // init the red and blue pointers

        for (int w = 0; w < nums.length && w <= b && b > 0; w++) { // init the white pointer
            if (nums[w] == 0) { // we found a red
                if (nums[r] != nums[w]) {
                    // Do the swap
                    nums[r] ^= nums[w];
                    nums[w] ^= nums[r];
                    nums[r] ^= nums[w];
                }

                // More the r and w forward, because we will check the w again against new r
                r++;
            } else if (nums[w] == 2) { // we found a blue
                if (nums[w] != nums[b]) {
                    // Do the swap
                    nums[w] ^= nums[b];
                    nums[b] ^= nums[w];
                    nums[w] ^= nums[b];
                }
            
                //Move only b back, so that we check w again against new b
                b--;
                w--;
            }
        } // we don't return anything per problem statement.
    }
}