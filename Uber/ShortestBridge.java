import java.util.ArrayDeque;

class Solution {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };; // faster as q then any other implementation

    public int shortestBridge(int[][] A) {
        boolean found = false;
        int row = A.length, col = A[0].length;
        boolean[][] visited = new boolean[row][col];

        Queue<int[]> q = createFirstIsland(A, visited);

        // BFS - expand the first island, until it reaches the second island
        int bridgeLength = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (didReachSecondIsland(A, visited, q)) {
                    return bridgeLength;
                }
            }
            bridgeLength++;
        }
        return -1;
    }

    private Queue<int[]> createFirstIsland(int[][] A, boolean[][] visited) {
        int row = A.length, col = A[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    getFirstIsland(A, i, j, visited, q);
                    return q;
                }
            }
        }
    }

    public void getFirstIsland(int[][] A, int i, int j, boolean[][] visited, Queue<int[]> q) {
        int row = A.length, col = A[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] == true)
            return;

        q.offer(new int[] { i, j });
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            getFirstIsland(A, x, y, visited);
        }
    }

    private boolean didReachSecondIsland(int[][] A, boolean[][] visited, Queue<int[]> q) {
        for (int[] dir : dirs) {
            int x = cur[0] + dir[0], y = cur[1] + dir[1];
            if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y]) {
                continue;
            }
            if (A[x][y] == 1) {
                return true;
            }

            visited[x][y] = true;
            q.offer(new int[] { x, y });
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