class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] row = getRowHelper(rowIndex);
        return Arrays.stream(row).boxed().collect(Collectors.toList());
    }

    private int[] getRowHelper(int cRowIndex) {
        if (cRowIndex == 0) {
            return new int[] { 1 };
        } else if (cRowIndex == 1) {
            return new int[] { 1, 1 };
        }

        int[] rowAbove = getRowHelper(cRowIndex - 1);
        int[] cRow = new int[rowAbove.length + 1];
        cRow[0] = 1;
        cRow[cRow.length - 1] = 1;

        for (int i = 1; i < cRow.length - 1; i++) {
            cRow[i] = rowAbove[i - 1] + rowAbove[i];
        }

        return cRow;
    }
}

/**
 * Input: 3
  Output: [1,3,3,1]

  What we know:
    * Length of row is 2 ^ n, where n is the level of triangle starting from 0
    * The first and last elements in a row are 1
    * elements between the last 2 depend on the sum of items in the row above as follows:
      - element at row above at index i - 1 + element at row above index i




              1             // first row is 2 ^ 0 or length 1, first and last elements are at same index, and are 1
            1   1           // so here we will add 1s to the end by default as well, and there is nothing in between them
          1   2   1         // here we will add first and last elements, and then check the middle elements based on the formula above
        1   3   3   1       // here we will add first and last elements, and then check the middle elements based on the formula above
    1     4   6   4   1
        


 */