import java.nio.CharBuffer;
import java.util.stream.IntStream;

class Solution {
  public int compress(char[] chars) {
    IntStream charStream = CharBuffer.wrap(chars).chars();
    StringBuilder compressedString = new StringBuilder();
    int[] count = { 0 };
    charStream.reduce((prevChar, currentChar) -> {
      if (currentChar == prevChar) {
        count[0]++;
      } else {
        compressedString.append("" + (char) prevChar + count[0]);
      }
      return currentChar;
    });

    System.out.println(compressedString.toString());

    return compressedString.length();
  }
}