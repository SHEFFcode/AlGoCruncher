object Solution extends App {
  def maxSubArray(nums: Array[Int]): Int = {
    val (_, gMax, negMax) = nums.foldLeft((0, 0, Int.MinValue)) {
      case ((cMax, gMax, nMax), cNum) => {
        val currMax = (cMax + cNum) max 0
        (currMax, currMax max gMax, nMax max cNum)
      }
    }

    if (gMax == 0) negMax else gMax
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
