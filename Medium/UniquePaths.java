/**
 * We will use a table where we will build up the number of paths from the number of paths already explored
 * We will begin with the realization that horizontally and down we can only go 1 way, then fill up from there
 * m = 3, n = 2
 *  -----------
 * | 1 | 1 | 1 |
 * | 1 | 2 | 3 |
 *  -----------
 * 
 * m = 7, n = 3
 *  --------------------------------
 * | 1 | 1 | 1 | 1  |  1 |  1 |  1 |
 * | 1 | 2 | 3 | 4  |  5 |  6 |  7 |
 * | 1 | 3 | 6 | 10 | 15 | 21 | 28 |
 *  -------------------------------
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] results = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    results[i][j] = 1;
                } else {
                    results[i][j] = results[i - 1][j] + results[i][j - 1];
                }
            }
        }

        return results[m - 1][n - 1];
    }
}