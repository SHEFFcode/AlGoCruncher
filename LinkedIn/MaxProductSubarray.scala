object Solution {
  def maxProduct(nums: Array[Int]): Int = {
    val len = nums.length
    val maxdp = Array.fill[Int](len)(0)
    val mindp = Array.fill[Int](len)(0)

    maxdp(0) = nums(0)
    mindp(0) = nums(0)

    for (i <- 1 until len) {
      if(nums(i) < 0) {
        maxdp(i) = Math.max(mindp(i - 1) * nums(i), nums(i))
        mindp(i) = Math.min(maxdp(i - 1) * nums(i), nums(i))
      } else {
        maxdp(i) = Math.max(maxdp(i - 1) * nums(i), nums(i))
        mindp(i) = Math.min(mindp(i - 1) * nums(i), nums(i))
      }
    }

    maxdp.max
  }
}

/*
  Input: [2, 3, -2, 4]
  Output: 6
  Explanation: [2, 3] has the largest product 6.
*/

/*
  Input: [-2, 0, -1]
  Output: 0
  Explanation: The result cannot be 2, because [-2, -1] is not a subarray.
*/