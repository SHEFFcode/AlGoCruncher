object Solution {
  def maxSubArray(nums: Array[Int]): Int = {
    val (gMax, _, negMax) = nums.foldLeft(0, 0, Int.MinValue) {
      case ((gMax, cMax, negMax), num) => {
        val newCMax = (cMax + num) max 0 // keep going or break
        val newGMax = gMax max newCMax
        val newNegMax = negMax max num // -3 max -1 => -1
        (newGMax, newCMax, newNegMax)
      }
    }

    if (gMax == 0) negMax else gMax // if 0, all nums were negative
  }
}

/*
G: nums; Array[Int]
O: maxSubarraySum: Int
T: O(N)
S: O(1)

Notes:
  - Numbers can be positive and negative

 */
