object Solution extends App {
  def trap(height: Array[Int]): Int = {
    val lMax = Array.ofDim[Int](height.length)
    val rMax = Array.ofDim[Int](height.length)
    val diff = Array.ofDim[Int](height.length)

    for (i <- 0 until height.length) {
      if (i == 0) lMax(i) = height(i)
      else lMax(i) = height(i) max lMax(i - 1)
    }

    for (i <- height.length - 1 to 0 by -1) {
      if (i == height.length - 1) rMax(i) = height(i)
      else rMax(i) = height(i) max rMax(i + 1)
    }

    for (i <- 0 until height.length) {
      diff(i) = (lMax(i) min rMax(i)) - height(i)
    }

    diff.sum
  }

  println(trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
}

/*
G: height: Array[Int]
O: maxWaterTrapped: Int
T: O(N)
S: O(N)

Notes:
  - n non negative integers representing elevation map
  - Width of each bar is 1
  - How much water can it trap after raining

Ex:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.


lMax: [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
rMax: [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]

min : [0, 1, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1]
bH  : [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
water:[0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0].sum = 6

0 1 2 3 4 5 6 7 8 9 10 11
0 1 0 2 1 0 1 3 2 1  2  1
i

 */
