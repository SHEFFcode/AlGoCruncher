import scala.collection.mutable.HashMap

object Solution {
  def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
    nums.zipWithIndex.foldLeft((0, HashMap[Int, Int]((0 -> -1)))) {
      case ((sum, brain), (num, i)) => {
        var cSum = if (k != 0) ((sum + num) % k) else (sum + num)
        if (brain.contains(cSum)) {
          if (i - brain(cSum) > 1) {
            // subarray of size 2 or more
            return true // short circuit
          }
          // do nothing, not long enough
        } else {
          brain(cSum) = i // put into map if absent
        }
        (cSum, brain)
      }
    }
    false // if we don't short circuit above, the sum is impossible
  }
}

/*
G: nums: Array[Int]
O: k: Int
T:  O(N)
S: O(N)

Notes:
  - list of non-negative numbers
  - target integer k
  - if the array has a continuous subarray of size at least 2 that sums up to a multiple of k
  - that is, sums up to n*k where n is also an integer.

Ex:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.



Ex2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

 */
