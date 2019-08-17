class Solution {
  public boolean isToeplitzMatrix(int[][] matrix) {
    int startI = 0;
    int startJ = 0;

    for (; startJ < matrix[0].length; startJ++) {
      int valueToFind = matrix[startI][startJ];
      for (int j = startJ, i = startI; j < matrix[0].length && i < matrix.length; j++, i++) {
        if (valueToFind != matrix[i][j]) {
          return false;
        }
      }
    }

    startI = 0;
    startJ = 0;

    for (; startI < matrix.length; startI++) {
      int valueToFind = matrix[startI][startJ];
      for (int j = startJ, i = startI; i < matrix.length && j < matrix[0].length; j++, i++) {
        if (valueToFind != matrix[i][j]) {
          return false;
        }
      }
    }

    return true;
  }
}