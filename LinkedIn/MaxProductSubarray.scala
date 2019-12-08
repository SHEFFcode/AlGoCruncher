object Solution {
  def maxProduct(nums: Array[Int]): Int = { //[2, 3, -2, 4]
    val len = nums.length // 4
    val maxValues = Array.fill[Int](len)(0) // [0, 0, 0, 0]
    val minValues = Array.fill[Int](len)(0) // [0, 0, 0, 0]

    maxValues(0) = nums(0) // [2, 0, 0, 0]
    minValues(0) = nums(0) // [2, 0, 0, 0]

    for (i <- 1 until len) { // 1, because we already filled the 0th spot 
      if(nums(i) < 0) { // if current number if negative
        maxValues(i) = Math.max(minValues(i - 1) * nums(i), nums(i)) // max subarray will get the result of previous position in min subarray * current negative number. It will then compare it to the current number
        // maxValues(i) = Math.max(2 * -2, -2) = -2 [2, 6, -2]
        
        minValues(i) = Math.min(maxValues(i - 1) * nums(i), nums(i)) // min sunarray will get the result of previous position in max subarray * current negative number. It will then compare it to the current number
        // minValues(i) = Math.min(6 * -2, -2) = -12 [2, 2, -12]
      } else { // if current number is positive
        maxValues(i) = Math.max(maxValues(i - 1) * nums(i), nums(i)) // max subarray will get the result of previous position in the max subarray * current positive number. It will then compare it to the current number
        // maxValues(i) = Math.max(2 * 3, 3) = 6 [2, 6, 0, 0]
        // maxValues(i) = Math.max(-2 * 4, 4) = 4 [2, 6, -2, 4]
        
        minValues(i) = Math.min(minValues(i - 1) * nums(i), nums(i)) // min sunarray will ge tthe result of the previous position in the min subarray * current negative number. it will then compare it to the current number
        // minValues(i) = Math.min(2 * 3, 3) = 2 [2, 2, 0, 0]
        // minValues(i) = Math.min(-2 * 4, 4) = -8 [2, 2, -12, -8]
      }
    }

    maxValues.max // [2, 6, -2, 4], max value is 6
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