import java.io.*;
import java.util.*;

class Solution {

  /**
   * double x: number to find, so this can be 0, 0.5, 1, 1.3, 1.333 int n: the
   * root coefficient, so this can be 1, 2, 3 etc this can NOT be 0 or less then 1
   * double y: can be 0.5, 1, 1.3, 1.333 Notes: - error of .001, so Math.abs(y -
   * root(x, n)) < 0.001 - 0 =< x - 0 < n
   * 
   * 
   * we will use binary search, so find a mid between two values, and keep looking
   * until we find a solution yFloor: since y cannot be less then 0, the floor can
   * only be 0 yCeiling: if (x > 1) y < x, else if (x =< 1) 1 mid = low + (high -
   * low / 2), to prevent overflow
   * 
   * x = 5, n = 2
   * 
   * x > 1, so mid = 0 + (5 - 0) / 2 = 2.5
   * 
   * 2.5^2 > 9, so we will take mid between mid and lowerbound
   * 
   * while (Math.abs(Math.pow(mid, n) - x) > .001): double poweredUp =
   * Math.pow(mid, n) if (poweredUp > x) { yCeiling = mid mid = yFloor + (yCeiling
   * - yFloor) / 2 } else if (poweredUp < x) { yFloor = mid mid = yFloor +
   * (yCeiling - yFloor) / 2 } else { break }
   * 
   * return mid
   * 
   */

  static double root(double x, int n) {
    double yFloor = 0.0;
    double yCeiling = Math.max(x, 1.0);
    double approxRoot = yFloor + (yCeiling - yFloor) / 2.0;

    while (Math.abs(Math.pow(approxRoot, n) - x) > .001) {
      double poweredUp = Math.pow(approxRoot, n);

      if (poweredUp > x) {
        // look lower by changing the ceiling
        yCeiling = approxRoot;
      } else if (poweredUp < x) {
        // look higher by chaning the floor
        yFloor = approxRoot;
      } else {
        break;
      }

      approxRoot = yFloor + (yCeiling - yFloor) / 2.0;
    }

    return approxRoot;
  }

  public static void main(String[] args) {

  }

}