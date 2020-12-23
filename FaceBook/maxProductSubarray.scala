object Solution {
  def maxProduct(nums: Array[Int]): Int = {
    // we do a tail, cause of product, we want to start with nums(0)
    val (gMax, _, _) = nums.tail.foldLeft(nums(0), nums(0), nums(0)) {
      case ((gMax, posMax, negMax), num) => {
        val nPosMax = (posMax * num) max (negMax * num) max num
        val nNegMax = (posMax * num) min (negMax * num) min num
        val nGMax = nPosMax max gMax
        (nGMax, nPosMax, nNegMax)
      }
    }

    gMax
  }
}

/*
G: nums: Array[Int]
O: maxProduct: Int
T: O(N)
S: O(1)

Notes:
  -  find the contiguous subarray within an array
  - which has the largest product.

Ex:

 */
