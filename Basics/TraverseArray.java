class TraverseArray {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[] requiredNums = {5, 6, 9};

        System.out.println(containsFiveSixNine(arr, requiredNums, 0));
    }

    private static boolean containsFiveSixNine(int[][] arr, int[] requiredNums, int index) {
        if (arr.length < requiredNums.length) {
            return false;
        }

        // first let's try to find that first require number
        int firstRequired = requiredNums[0];
        boolean foundAllRequired = false;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == firstRequired) {
                    if (checkNeighbors(arr, i, j, requiredNums, index + 1) == true) {
                        foundAllRequired = true;
                    }
                }
            }
        }

        return foundAllRequired;
    }

    private static boolean checkNeighbors(int[][] arr, int i, int j, int[] requiredNums, int index) {
        // we found all the requiredNums
        if (index == requiredNums.length) {
            return true;
        }

        int[][] neighbors = {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
        };

        for (int k = 0; k < 4; k++) {
            int nextI = i + neighbors[k][0];
            int nextJ = j + neighbors[k][1];

            try {
                if (arr[nextI][nextJ] == requiredNums[index]) {
                    if (checkNeighbors(arr, nextI, nextJ, requiredNums, index + 1) == true) {
                        return true;
                    }
                }
            } catch (Exception e) {
                continue; // we will just swallow the exception here, we would generally log, but this is an interview
            }

        }

        return false;
    }
}


/*

    [1, 2, 3]
           *  
    [4, 5, 6]
       *
   [7, 8, 9]








*/