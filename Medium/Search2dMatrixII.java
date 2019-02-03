/**
 * Target is 5
 * We start at the top right corner as it's the biggest going across and the smallest going down
 * [
    [1,   4,  7, 11, 15],
                      *  here 15 is bigger then 5, so we should go left
                  * here 11 is bigger then 5, so we go left
              * here 7 is bigger then 5 so we go left
          * here 4 is smaller then 5, so we go down
    [2,   5,  8, 12, 19],
          * here 5 is equal to 5 so we return true
    [3,   6,  9, 16, 22],

    [10, 13, 14, 17, 24],

    [18, 21, 23, 26, 30]
  ]


  Target is 20
  [
    [1,   4,  7, 11, 15],
                      * here 15 is smaller then 20 so we go down
    [2,   5,  8, 12, 19],
                      * here 19 is smaller then 20 so we go down
    [3,   6,  9, 16, 22],
                      * here 22 is bigger then 20 so we go left
                 * here 16 is smaller then 20 so we go down
    [10, 13, 14, 17, 24],
                  * here 17 is smaller then 20 so we go down
    [18, 21, 23, 26, 30]
                  * here 26 is bigger then 20 so we go left
             * 23 is bigger then 20 so we go left
         * 21 is bigger then 20 so we go left
      * 18 is smaller then 20 so we try to go down, but we are out of bond, so we return -1
  ]
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // first let's check if the matrix can even have our target
        int n = matrix.length;
        int m = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
            return false;
        }

        // set up our pointers
        int r = 0;
        int c = m - 1;

        // Let's iterate only when we are in bounds
        while (r <= n - 1 && c >= 0) {
            if (matrix[r][c] < target) { // we go down
                r++;
            } else if (matrix[r][c] > target) { // we go left
                c--;
            } else { // we found the item
                return true;
            }
        }

        // if we iterated and are now out of bounds, the item does not exist in the matrix
        return false;
    }
}