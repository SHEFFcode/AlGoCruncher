class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    char[] one = text1.length() < text2.length() ? text1.toCharArray() : text2.toCharArray();
    char[] two = text1.length() >= text2.length() ? text1.toCharArray() : text2.toCharArray();
    int iMax = one.length;
    int jMax = two.length;
    int lcs = 0;
    int jMem = 0;

    for (int i = 0; i < iMax; i++) {
      for (int j = jMem; j < jMax; j++) {
        if (one[i] == two[j]) {
          lcs++;
          jMem = j + 1;
          break;
        }
      }
    }

    return lcs;
  }
}