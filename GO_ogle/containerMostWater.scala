object Solution extends App {
  def maxArea(height: Array[Int]): Int = {
    def findMaxArea(start: Int, end: Int, maxArea: Int): Int = {
      if (start == end) return maxArea
      val cArea = (height(start) min height(end)) * (end - start)
      val newMax = cArea max maxArea
      if (height(end) > height(start)) findMaxArea(start + 1, end, newMax)
      else findMaxArea(start, end - 1, newMax)
    }
    findMaxArea(0, height.length - 1, 0)
  }

  println(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}

/*
G: height: Array[Int]
O: maxArea: Int
T: O(N)
S: O(N)

Notes:
  - non negative integers
  -

Ex:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

0 1 2 3 4 5 6 7 8
1 8 6 2 5 4 8 3 7
            i
            j

cMax = j + 1 - i * min(heights(i), heights(j)) = 5 * 6
gMax = 56

if they are the same move the left one
if they are different, move the smaller one
while they meet we move them together
also if we keep track of last one we moved away from, we would have to find a number bigger then it for math to work
 */

/*

object Solution {
  def maxArea(height: Array[Int]): Int = {
    def findMaxArea(start: Int, end: Int, maxArea: Int): Int = {
      if (start == end) return maxArea
      val cArea = Math.min(height(start), height(end)) * (end - start)
      val newMax = Math.max(cArea, maxArea)
      if (height(end) > height(start)) findMaxArea(start + 1, end, newMax)
      else findMaxArea(start, end - 1, newMax)
    }
    findMaxArea(0, height.length - 1, 0)
  }
}*/
