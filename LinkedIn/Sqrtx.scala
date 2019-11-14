import scala.math.max

object Solution {
    def mySqrt(x: Int): Int = {
        if (x < 2) return x

        val left = 2
        val right = x / 2

        doRecursion(left, right, x)
    }

    private def doRecursion(left: Int, right: Int, goal: Int): Int = {
        if (left > right) {
            right
        } else {
            val pivot = left + (right - left) / 2
            val candidate = pivot * pivot
            if (candidate > goal) doRecursion(left, pivot - 1, goal)
            else if (candidate < goal) doRecursion(pivot + 1, right, goal)
            else pivot;
        }
    }
}


/*
Input: 4
Output: 2

We will do this via a binary search by dividing by 2


4 / 2 = 2

if (2 * 2 == 4) 2
else if (2 * 2 > 4)


Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.


8 / 2 = 4

if (4 * 4 == 8) 4
else if (4 * 4 > 8) runRecursive(4 / 2)
else if (4 * 4 < 8) return 4

*/

/*

class Solution {
  public int mySqrt(int x) {
    if (x < 2) return x;

    long num;
    int pivot, left = 2, right = x / 2;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      num = (long)pivot * pivot;
      if (num > x) right = pivot - 1;
      else if (num < x) left = pivot + 1;
      else return pivot;
    }

    return right;
  }
}

*/