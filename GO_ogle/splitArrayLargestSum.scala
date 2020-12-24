object Solution {
  def splitArray(nums: Array[Int], m: Int): Int = {
    var (lo, hi) = nums.foldLeft(0, 0) {
      // minimum max is the largest number
      // maximum max is the sum of the whole array
      case ((minMax, maxMax), n) => (minMax max n, maxMax + n)
    }

    while (lo < hi) { // between largest (lo) number and whole arr sum (hi)
      val sumToTry = lo + (hi - lo) / 2 // look for sum between low and high
      val pieces = split(nums, sumToTry) // cnt pieces for this sum

      if (pieces > m) lo = sumToTry + 1 // we overshot, incr sum to decr pieces
      else hi = sumToTry // we undershot, decr sum to incr pieces
    }
    lo // lo will be equal to hi here
  }

  private def split(nums: Array[Int], sumToTry: Int): Int = {
    val (pieces, _) = nums.foldLeft(1, 0) {
      case ((pieces, cSum), num) => {
        if (cSum + num > sumToTry) (pieces + 1, num) // create a new piece
        else (pieces, cSum + num) // keep building up existing piece
      }
    }
    pieces
  }
}

/*
G: nums: Array[Int], m: Int
O: minSum: Int
T: O(N)
S: O(NM)

Notes:
  - Nums are non negative integers
  - m integer
  - Split into m non empty continious subarrays
  - minimize the largest sum amongst the subarrays

Ex:
Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

Ex2:
Input: nums = [1,2,3,4,5], m = 2
Output: 9

Ex3:
Input: nums = [1,4,4], m = 3
Output: 4
 */
