object Solution {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    for (i <- 0 until nums.size) {
      val num = nums(i)
      if (num == target) {
        return i
      } else if (num > target) {
        return i
      }
    }

    return nums.size
  }
}

/*
G: sortedNums: Array[Int], target: Int
O: index: Int <- index where the item is found or where it should be if inserted
T: nLogN? since it's sorted nLogN runtime is reasonable
S: O(1) i think we can do in constant space

Input: [1,3,5,6], 5
Output: 2

[1, 3, 5, 6]
 *
We start at the beginning of the array and keep looking
1) If we find a value we return index
2) If we get to a number bigger then target we return current index
2.5) If the first number is bigger then target, return index
3) If we run out of numbers we return index + 1


Input: [1,3,5,6], 2
Output: 1

[1, 3, 5, 6]
 *


Input: [1,3,5,6], 7
 *
Output: 4


Input: [1,3,5,6], 0
Output: 0
 */
