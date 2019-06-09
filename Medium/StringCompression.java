import java.nio.CharBuffer;
import java.util.stream.IntStream;

class Solution {
  public int compress(char[] chars) {
    int i = 0; // will keep track of where to put

    for (int j = 0; j < chars.length;) { // we will increment i along with j in the outer loop
      int count = 1; // we got at least 1 letter.
      chars[i++] = chars[j++]; // we will do our incrementation here because we want i to start at 0 for empty
                               // array, but go to 1 if we get into this loop

      while (j < chars.length && chars[j] == chars[j - 1]) {
        j++; // in the inner loop we only move j, as it will tell us how many letter we will
             // compress.
        count++; // increase compressed letter count.
      }

      if (count > 1) { // if we have count greater than 1, we want to update the chars[] in place
        for (char c : String.valueOf(count).toCharArray()) { // method to iterate through char[] version of count
          chars[i++] = c;
        }
      }
    }

    return i; // this will correspond to the length of compressed string, everything after is
              // uncompressed remainder.
  }
}