import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
  public String multiply(String num1, String num2) {
    int number1 = getNumFromString(num1);
    int number2 = getNumFromString(num2);

    return String.valueOf(number1 * number2);
  }

  private int getNumFromString(String num) {
    int number = 0;
    int multiplier = (int) Math.pow(10, num.length() - 1);
    char[] numChars = num.toCharArray();

    for (char c : numChars) {
      int cNum = c - '0';
      number += cNum * multiplier;
      multiplier /= 10;
    }

    return number;
  }
}

/**
 * Input: num1 = "2", num2 = "3" Output: "6"
 * 
 * We could use parseInt to get the integer and then toString() it
 * 
 * (Integer.parseInt(num1) * Integer.parseInt(num2)).toString()
 */