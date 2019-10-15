import java.util.List;
import java.util.Set;

class Solution {
    private int bridgeLength = 0;

    public int shortestBridge(int[][] A) {
        List<String> firstIsland = new ArrayList<>();
        List<String> secondIsland = new ArrayList<>();
        Set<String> secondIslandCoordinates = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int islandCount = 0;

        List<String> currentIsland = firstIsland;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1 && !visited.containsKey("" + i + "," + j)) {
                    createIsland(i, j, A, currentIsland);
                    islandCount++; // we created an island.
                    if (islandCount == 1) {
                        currentIsland = secondIsland; // this will work because we know there are always 2 islands
                    } else {
                        throw new Exception("There are more then 2 islands!");
                    }
                }
            }
        }

        // let's make a map out of that second island.
        secondIsland.forEach(coordinate -> secondIslandCoordinates.add(coordinate)); // this way we have O(1) retrieval

        // we now have the two islands.  Let's try to grow from each of their points to reach the other
        // TODO: Mathematically optimize this
        firstIsland.forEach(landCoordinate -> {
            growIsland(coordinate, A, secondIslandCoordinates, 0);
        });

        return bridgeLength;
    }

    private void growIsland(String coordinate, int[][] islands, Set<String> secondIslandCoordinates, int bridgeLength) {
        if (secondIslandCoordinates.contains(coordinate)) {
            return;
        }

        String[] c = coordinate.split(",");
        int i = Integer.parseInt(c[0]);
        int j = Integer.parseInt(c[1]);

        int prevI, nextI, prevJ, nextJ; // let's define these here and use them in the loops

        if (prevI = i - 1 > -1 && islands[prevI][j] == 1) {
            createIsland(prevI, j, islands, currentIsland);
        } else if (nextI = i + 1 < islands.length && islands[nextI][j] == 1) {
            createIsland(nextI, j, islands, currentIsland);
        } else if (prevJ = j - 1 > -1 && islands[i][prevJ] == 1) {
            createIsland(i, prevJ, islands, currentIsland);
        } else if (nextJ = j + 1 < islands.length && islands[i][nextJ] == 1) {
            createIsland(i, nextJ, islands, currentIsland);
        }

    }

    private void createIsland(int i, int j, int[][] islands, List<String> currentIsland) {
        currentIsland.add("" + i + "," + j); // add a new point

        int prevI, nextI, prevJ, nextJ; // let's define these here and use them in the loops

        if (prevI = i - 1 > -1 && islands[prevI][j] == 1) {
            createIsland(prevI, j, islands, currentIsland);
        } else if (nextI = i + 1 < islands.length && islands[nextI][j] == 1) {
            createIsland(nextI, j, islands, currentIsland);
        } else if (prevJ = j - 1 > -1 && islands[i][prevJ] == 1) {
            createIsland(i, prevJ, islands, currentIsland);
        } else if (nextJ = j + 1 < islands.length && islands[i][nextJ] == 1) {
            createIsland(i, nextJ, islands, currentIsland);
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