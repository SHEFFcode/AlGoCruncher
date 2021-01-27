object Solution {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    var l = 0
    var r = numbers.length - 1

    while (l < r) {
      val sum = numbers(l) + numbers(r)

      if (sum == target) return Array(l + 1, r + 1)
      else if (sum < target) l += 1
      else r -= 1
    }

    Array(-1, -1)
  }
}

/*
G: numbers: Array[Int], target: Int
O: numsAddToTarget: Array[Int]
T: O(N)
S: O(n)

Notes:
  - Numbers is an array of integers that are already sorted in asc order
  - Find 2 numbers that add up to a target
    ^ index1 must be less than index2
  - Your returned answers (both index1 and index2) are not zero-based.
  - You may assume that each input would have exactly one solution and you may not use the same element twice.


Ex:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

Ex2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]

Ex3:
Input: numbers = [-1,0], target = -1
Output: [1,2]





 */
