import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
  public String multiply(String num1, String num2) {
    int num1Length = num1.length();
    int num2Length = num2.length();
    int[] sum = new int[num1Length + num2Length]; // we can always have a number of num1.length + num2.length in
                                                  // case we add 9 to 8 or something

    for (int i = num1Length - 1; i > -1; i--) {
      for (int j = num2Length - 1; j > -1; j--) {
        int cMult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int cSum = sum[i + j + 1] + cMult;
        sum[i + j + 1] = cSum % 10; // this will be the lower number during the multiplication, whatever is left
                                    // after modulo 10
        sum[i + j] += cSum / 10; // this will be the carry digit.
      }
    }

    String result = Arrays.stream(sum).mapToObj(String::valueOf).collect(Collectors.joining("")).replaceFirst("^[0]+",
        "");

    return result.length() == 0 ? "0" : result;
  }
}

/**
 * Key here is to remember how to do multiplication by hand, so
 * 
 * 48 56 -- 48 24 40 20 ----- 2688
 */