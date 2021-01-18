object Solution {
  def findMin(nums: Array[Int]): Int = {
    if (nums.length == 1) return nums(0)
    var left = 0
    var right = nums.length - 1
    // this means there was no rotation, so smallest el up front
    if (nums(right) > nums(left)) return nums(left)

    while (right >= left) {
      val mid = left + (right - left) / 2

      // inflection point (aka smallest el) is its right neighbor
      if (nums(mid) > nums(mid + 1)) {
        return nums(mid + 1)
      }

      // you are at inflection point, and therefore lowest el
      if (nums(mid - 1) > nums(mid)) {
        return nums(mid)
      }

      // inflection point must be to the right
      // move up left and find new mid
      if (nums(mid) > nums(0)) {
        left = mid + 1
      } else {
        // inflection point must be to the left
        right = mid - 1
      }
    }

    return -1 // if we don't find anything
  }
}

/*
G: nums: Array[Int]
O: minValue: Int
T: log(n)
S: O(1)

Notes:
  - Array is sorted in ascending order is rotated between 1 and n times
  - Return minimum element

Ex:

 */
