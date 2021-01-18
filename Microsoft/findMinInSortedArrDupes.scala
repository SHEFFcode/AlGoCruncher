object Solution {
  def findMin(nums: Array[Int]): Int = {
    var low = 0
    var high = nums.length - 1

    while (low < high) {
      val mid = low + (high - low) / 2

      if (nums(mid) < nums(high)) {
        // we have a sorted, monotonically incr section, so look left of mid
        high = mid
      } else if (nums(mid) > nums(high)) {
        // inflection is somewhere between mid and high
        low = mid + 1
      } else {
        // mid and high are the same, move high closer to mid
        high -= 1
      }
    }

    nums(low)
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
  - Array can contain duplicates

Ex:

 */
