class Solution {
  public boolean isToeplitzMatrix(int[][] matrix) {

    for (int startJ = 0, startI = 0; startJ < matrix[0].length; startJ++) {
      int valueToFind = matrix[startI][startJ];
      for (int j = startJ, i = startI; j < matrix[0].length && i < matrix.length; j++, i++) {
        if (valueToFind != matrix[i][j]) {
          return false;
        }
      }
    }

    for (int startI = 0, startJ = 0; startI < matrix.length; startI++) {
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