class Solution {
    public int uniquePaths(int m, int n) {
        int numPaths = 0;
        int i = 0, j = 0;
        for (; i < m; i++) {
            for (; j < n; j++) {
                numPaths += helper(i, j, m, n);
            }
        }

        return numPaths;
    }

    private int helper(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        int currentNumPaths = 0;

        if (i < m - 1) {
            currentNumPaths += helper(i + 1, j, m, n);
        }

        if (j < n - 1) {
            currentNumPaths += helper(i, j + 1, m, n)
        }

        return currentNumPaths;
    }
}