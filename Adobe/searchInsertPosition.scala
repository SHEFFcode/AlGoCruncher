object Solution {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    var left = 0
    var right = nums.length - 1
    while (left <= right) {
      val pivot = left + (right - left) / 2
      if (nums(pivot) == target) return pivot
      if (target < nums(pivot)) right = pivot - 1
      else left = pivot + 1
    }
    left
  }
}

/*
G: nums: Array[Int], target: Int
O: insertPosition: Int
T: O(log(n))
S: any

Notes:
  -

Ex:
Input: nums = [1,3,5,6], target = 5
Output: 2

Ex2:
Input: nums = [1,3,5,6], target = 2
Output: 1

 */
