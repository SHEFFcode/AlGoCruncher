package com.company;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(
                new int[][] {
                    {9,9,4},
                    {6,6,8},
                    {2,1,1}
                }
        ));
    }
}

class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int nrows = matrix.length;
        int ncols = 0;
        if (nrows > 0) {
            ncols = matrix[0].length;
        }

        int[][] visited = new int[nrows][ncols];
        int max = 0;

        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncols; j++) {
                max = Math.max(max, explore(i, j, matrix, visited));
            }
        }

        return max;
    } /* end longestIncreasingPath() */

    private int explore(int i, int j, int[][] matrix, int[][] visited) {
        if (i < 0 || j < 0 || i == matrix.length || j == matrix[0].length) {
            return 0;
        }

        if (visited[i][j] > 0) {
            return visited[i][j];
        }

        int myPaths = 1;
        int neighborPaths = 0;
        visited[i][j] = myPaths;

        for (int l = -1; l < 2; l += 2) {
            if (i + l > -1 && i + l < matrix.length && j < matrix[0].length && matrix[i + l][j] > matrix[i][j]) {
                int tmp = explore(i + l, j, matrix, visited);
                neighborPaths = Math.max(tmp, neighborPaths);
            }
        }
        for (int m = -1; m < 2; m += 2) {
                if (j + m > -1 && i < matrix.length && j + m < matrix[0].length && matrix[i][j + m] > matrix[i][j]) {
                    int tmp = explore(i, j + m, matrix, visited);
                    neighborPaths = Math.max(tmp, neighborPaths);
            }
        }

        visited[i][j] += neighborPaths;
        return visited[i][j];
    } /* end explore() */
}
