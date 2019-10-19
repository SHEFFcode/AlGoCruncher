class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int area = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                area = Math.max(area, maxCurrentIsland(i, j, grid, visited));
            }
        }

        return area;
    }

    private int maxCurrentIsland(int i, int j, int[][] grid, boolean[][] visited) {
        // basic in bounds / non duplication check
        if (i < 0 || // i is within the bounds of array
                i >= grid.length || // is within bounds of array
                j < 0 || // is within bounds of array
                j >= grid[0].length || // is within bounds of array
                visited[i][j] || // we visited this spot before
                grid[i][j] == 0 // this spot is not an island
        ) {
            return 0; // therefore we cannot have an area calculation here
        }

        visited[i][j] = true; // let's remember that we have visited this spot before

        return (1 + // area of current square is 1 by definition
                maxCurrentIsland(i + 1, j, grid, visited) + // let's peek an island above, error will be caught by sanity check above
                maxCurrentIsland(i - 1, j, grid, visited) + // let's check the island below
                maxCurrentIsland(i, j + 1, grid, visited) + // let's check island to the right
                maxCurrentIsland(i, j - 1, grid, visited) // let's check island to the left
        );
    }
}

/**
 * We will basically do a recursive scan with a visited array
 * 
 * 
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
    [0,0,0,0,0,0,0,1,1,1,0,0,0],
    [0,1,1,0,1,0,0,0,0,0,0,0,0],
    [0,1,0,0,1,1,0,0,1,0,1,0,0],
    [0,1,0,0,1,1,0,0,1,1,1,0,0],
    [0,0,0,0,0,0,0,0,0,0,1,0,0],
    [0,0,0,0,0,0,0,1,1,1,0,0,0],
    [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 */