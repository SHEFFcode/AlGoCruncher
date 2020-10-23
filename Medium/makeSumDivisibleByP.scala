import scala.collection.mutable
object Solution extends App {
  def minSubarray(nums: Array[Int], p: Int): Int = {
    val sum: Int = nums.sum
    val remainder: Int = sum % p

    remainder match {
      case 0 => 0
      case _ => {
        val brain = mutable.HashMap(0 -> -1)
        // min can't be n, since we cannot exclude all nums
        val min = nums.length
        val posResult = nums.zipWithIndex.foldLeft((brain, min, 0)) {
          (acc, numWithIndex) =>
            {
              val (num, idx) = numWithIndex
              val (brain, min, prefixSum) = acc

              val cSum = prefixSum + num
              val key = (cSum % p - remainder) % p
              var res = min

              if (brain.contains(key)) {
                res = math.min(min, idx - brain(key))
              }
              brain(cSum % p) = idx
              (brain, res, cSum)
            }
        }

        if (posResult._2 < min) posResult._2 else -1
      }
    }
  }
  println(minSubarray(Array(6, 3, 5, 2), 9))
}

/*
G: positiveIntegers: Array[Int]
O: lengthOfRemovedSubarray: Int
T: O(n)
S: O(n)

Notes:
  - Not allowed to remove the whole array
  - Integers are positive
  - LengthOfRemovedSubarray is the smallest subarray that needs to be removed for the remainder sum to be divisible by p
  - Subwarray is contigious block of elements in array
  - DP, because we will have repeating subproblems

Ex1:
Input: nums = [3,1,4,2], p = 6
Output: 1
Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.

TotalSum = 10, remainder = 10 % 6 = 4
{
  0-0: 3
  0-1: 4
  0-2: 8
  0-3: 10
}

[ 3, 1, 4, 2 ], p = 6
 *


Ex2:
Input: nums = [6,3,5,2], p = 9
Output: 2
Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.

total = 16, remainder = 7

{
  0-0: 6
  0-1: 9
  0-2: 14
  0-3: 16
}


I am looking for 8
slow = 6
fast = 6
diff = 0



[6, 9, 14, 16]
 *
       #


1) Set up two pointers, slow and fast
  - Calculate 3 items: fast, slow and diff
  - If either of those is the number you are looking for, you are done
  - if not
    - if max is too low, move fast forward
    - If diff is too high, move slow forward
    - If diff is too low, move fast forward
2) Once u find the value, calculate fast - slow


[16, 10,  7,  2]

[ 6 , 3 , 5 , 2 ], p = 9
 *




EX:3
Input: nums = [1,2,3], p = 3
Output: 0
Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.

REMAINDER IS 0, so no more work needed
[ 1 , 2 , 3 ] P = 3

Ex:4
Input: nums = [1,2,3], p = 7
Output: -1
Explanation: There is no way to remove a subarray in order to get a sum divisible by 7.

1+2+3 = 6 if p > sum, return -1

[ 1 , 2 , 3 ] p = 7
 *

 */
