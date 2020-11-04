object Solution extends App {
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val first = binarySearch(nums, target)
    // we find first just higher then target, so go one back one
    val last = binarySearch(nums, target + 1) - 1
    if (first > last) Array(-1, -1) else Array(first, last)
  }

  def binarySearch(nums: Array[Int], x: Int): Int = {
    val n = nums.size
    var firstPos =
      n // first occurrence of item larger then x is just after the array
    var low = 0 // default start
    var high = n - 1 // default end

    while (low <= high) {
      val mid = low + (high - low) / 2
      if (nums(mid) >= x) {
        firstPos = mid // possible first position
        // go to the left and find lower vals bigger then or equal to x
        high = mid - 1
      } else {
        // go to the right and look for higher vals to reach at least x
        low = mid + 1
      }
    }
    firstPos
  }

  searchRange(Array(5, 7, 7, 8, 8, 10), 5)
}

/*
G: sortedArr: Array[Int], target: Int
O: startEndPos: Array[Int]
T: Log(n)
S: O(1)

Notes:
 * Array is sorted in asc order

nums = [5,7,7,8,8,10], target = 8

5 7 7 8 8 10  |  8 => [ 3, 4 ]
 *   *

Steps:
1) Find the first occupance of target using binary search (if none found, short circuit to [-1, -1])
2) Find the last occurrence of target (using binary search)

Notes:
  - The way to find the first occurrence, basically find the last element of the number smaller then target

 */
