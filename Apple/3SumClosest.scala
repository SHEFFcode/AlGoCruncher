import scala.math._
object Solution {
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    var closestSum = nums.take(3).sum
    if (nums.length == 3) return closestSum

    var smallestDiff = closestSum - target
    val sNums = nums.sorted

    for (i <- 0 until nums.length - 2) {
      var j = i + 1
      var k = nums.length - 1

      while (j < k) {
        val sum = sNums(i) + sNums(j) + sNums(k)
        val diff = sum - target
        //save the minimal diff
        if (abs(diff) < abs(smallestDiff)) {
          smallestDiff = diff
          closestSum = sum
        }

        if (sum > target) k -= 1
        else if (sum < target) j += 1
        else return target // we found exact match
      }
    }

    closestSum
  }
}

/*
G: nums: Array[Int], target: Int
O: sumOf3ClosestNums: Int
T: O(N)
S: O(N)

Notes:
  - Find three integers in nums such that the sum is closest to target.
  - Return the sum of the three integers. You may assume that each input would have exactly one solution.

Ex:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
