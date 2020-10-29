import scala.annotation.tailrec
object Solution extends App {
  def nextPermutation(nums: Array[Int]): Unit = {
    if (nums.length >= 2) {
      reverseOrSwap(nums, nums.length - 2, nums.length - 1)
    }
  }

  @tailrec
  def reverseOrSwap(nums: Array[Int], left: Int, right: Int): Unit = {
    if (left < 0) {
      reverse(nums, 0, nums.length - 1)
    } else if (nums(left) >= nums(right)) {
      // keep searching
      reverseOrSwap(nums, left - 1, right - 1)
    } else {
      // do the work
      swap(nums, left, nums.length - 1)
      reverse(nums, right, nums.length - 1)
    }
  }

  @tailrec
  def swap(nums: Array[Int], left: Int, right: Int): Unit = {
    if (left == right) ()
    else if (nums(right) <= nums(left)) {
      // keep moving from smaller to greater
      // (from end of array to the left)
      // until u find a spot where nums(left) (the fixed point)
      // is bigger then nums(right) (the moving point)
      swap(nums, left, right - 1)
    } else {
      // do the actual swap
      val numsLeft = nums(left)
      nums(left) = nums(right)
      nums(right) = numsLeft
    }
  }

  def reverse(nums: Array[Int], left: Int, right: Int): Unit = {
    if (left >= right) ()
    else {
      val numsLeft = nums(left)
      nums(left) = nums(right)
      nums(right) = numsLeft
      reverse(nums, left + 1, right - 1)
    }
  }

  val arr = Array(1, 5, 8, 4, 7, 6, 5, 3, 1)
  nextPermutation(arr)
  println(scala.runtime.ScalaRunTime.stringOf(arr))
}

/*
G: nums: Array[Int]
O: ()
T: O(N)
S: O(1) -> must be done in place

Notes:
 * Rearrange numbers into lexographically greater permutation of numbers
 * If not possible, rearrange into lowest possible order (sorted in ASC order)

Ex1:
[1,2,3] => [1,3,2]

1 3 2
  # *

Ex2:
[3,2,1] => [1,2,3]

1, 2, 3
# *

Ex3:
[1,1,5] => [1,5,1]

1 5 1
  # *

Ex4:
[1] => [1]

1

Steps:
 * Find the first index where nums(i) < nums(j)
 * Swap nums(i) with the smallest number (end of the array)
 * Reverse numbers from i + 1 to the end of the array
 */
