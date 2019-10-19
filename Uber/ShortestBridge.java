class Solution {
    private int bridgeLength = 0;
    private int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int shortestBridge(int[][] A) {
        int rowCount = A.length, colCount = A[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Coordinate> islandLands = tabulateIslandLands(A, visited);

        // now let's expand the island in a BFS fashion to find second island
        while (!islandLands.isEmpty()) {
            // let's do BFS here
            int size = islandLands.size();
            for (int i = 0; i < size; i++) {
                Coordinate current = islandLands.poll();
                if (growIsland(coordinate, A, islandLands, visited)) {
                    return bridgeLength;
                }
            }
            bridgeLength++;
        }

        return 1; // we are guaranteed 2 islands, so the default answer will be 1, we could throw an error also
    }

    private Queue<Coordinate> tabulateIslandLands(int[][] islandMap, boolean[][] visited) {
        Queue<Coordinate> islandLands = new ArrayDeque<>(); // ArrayDeque is faster as a queue then linked list
        boolean found = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (islandMap[i][j] == 1) {
                    found = true;
                    getFirstIsland(i, j, islandMap, islands, visited);
                    return islandLands;
                }
            }
        }

        return islandLands;
    }

    private void getFirstIsland(int i, int j, int[][] islandMap, Queue<Coordinate> islandLands, boolean[][] visited) {
        int row = islandMap.length, col = islandMap[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] == true) {
            return;
        }

        islandLands.offer(new Coordinate(i, j)); // let's fill up our queue.
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            getFirstIsland(x, y, islandMap, islandLands, visited);
        }
    }

    private boolean growIsland(Coordinate coordinate, int[][] A, Queue<Coordinate> islandLands, boolean[][] visited) {
        for (int[] dir : dirs) {
            int x = coordinate.x + dir[0], y = coordinate.y + dir[1];
            if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y])
                continue;
            if (A[x][y] == 1) {
                return true;
            }
            visited[x][y] = true;
            islandLands.offer(new Coordinate(x, y));
        }
    }

    private class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/**
 * We know for a fact that there are 2 islands. We go off and try to find them, by adding island points to an array
 * So there will be 2 ArrayLists that will contain tuples (x,y) that will indicate island points
 * We can do some sort of math optimization here, but we can just as easily just explore all points in one array
 * and grow them in all directions in BFS manner (maintaining the level count, which will serve as the solution)
 * till they hit the other island's members.
 * 
 * 
 * [
 *  [0,1]
 *     *
 *  [1,0]
 * ]
 * 
 * 
 * 
 * [
 *  [0,1,0]
 *     *
 *  [0,0,0]
 * 
 *  [0,0,1]
 * ]
 * 
 * 
 */