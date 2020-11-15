import scala.collection.mutable
object Solution extends App {
  def minSubarray(nums: Array[Int], p: Int): Int = {
    val mod = nums.foldLeft(0)((cMod, num) => (cMod + num) % p)
    var minAns = nums.length
    mod match {
      case 0 => 0
      case _ => {
        val brain = mutable.HashMap(0 -> -1)

        nums.zipWithIndex.foldLeft(0, brain) {
          case ((runningMod, brain), (num, idx)) => {
            val modAtIdx = (runningMod + num) % p
            val compliment = (p - mod + modAtIdx) % p
            if (brain.contains(compliment)) {
              minAns = math.min(minAns, idx - brain(compliment))
            }
            brain(modAtIdx) = idx
            (modAtIdx, brain)
          }
        }

        if (minAns < nums.length) minAns else -1
      }
    }
  }
  println(minSubarray(Array(3, 1, 4, 2), 6))
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

The key here is to keep track of index sum, such that:
 * Mod of (Mod of all numbers up to this one + this one) is mapped to current index
 * A compliment is seeked at each step of the way such that:
 *  Divisor - total remainder + running remainder is 0

 */
