import java.lang.reflect.Array;

class Solution {
  public int compress(char[] chars) {
    int arrLen = chars.length; // Start high, subtract away

    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars.length; j++) {
        if (chars[i] != chars[j] || j == chars.length - 1) {
          int savings = doCompression(i + 1, chars, j == chars.length - 1 ? j - i + 1 : j - i); // Compress returns
                                                                                                // savings through
                                                                                                // compression
          arrLen -= savings;
          i = j + savings;
        } // otherwise just keep traversing
      }
    }

    return arrLen;
  }

  private int doCompression(int index, char[] input, int len) {
    System.out.println(index);
    System.out.println(len);
    if (len == 1)
      return 0;
    char[] charLen = ("" + len).toCharArray();
    for (char lenChar : charLen) {
      Array.setChar(input, index++, lenChar);
    }
    return len - charLen.length - 1;
  }
}