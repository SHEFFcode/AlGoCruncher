object Solution extends App {
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
    var minSubarrLen = nums.length + 1 // Reasonable max
    var sumSoFar = 0
    var left = 0

    // grow the window
    for (right <- 0 until nums.length) {
      sumSoFar += nums(right)
      // shrink the window
      while (sumSoFar >= s) {
        // +1 here to adjust for 0 based counting
        minSubarrLen = minSubarrLen min (right + 1 - left)
        sumSoFar -= nums(left) // shrink sum
        left += 1 // shrink window
      }
    }

    if (minSubarrLen < nums.length + 1) minSubarrLen else 0
  }

  println(minSubArrayLen(7, Array(2, 3, 1, 2, 4, 5)))
}

/*
G: s: Int, nums: Array[Int]
O: minSizeSubarraySum: Int
T: O(N) || O(n log(n))
S: Any

Notes:
  - nums will be positive integers
  - s will be a positive integer
  - Subarray will need to be contiguous
  - sum >= s
  - If non found, return 0 instead
  - We are looking for the minimal length of such array
 */
