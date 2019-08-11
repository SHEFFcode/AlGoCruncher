class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    int iMax = text1.length(), jMax = text2.length();
    char[] one = text1.toCharArray(), two = text2.toCharArray();
    int[][] cache = new int[iMax + 1][jMax + 1];

    for (int i = 1; i <= iMax; i++) {
      for (int j = 1; j <= jMax; j++) {
        if (one[i - 1] == two[j - 1]) {
          cache[i][j] = cache[i - 1][j - 1] + 1;
        } else {
          cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
        }
      }
    }
    return cache[iMax][jMax];
  }
}