import scala.collection.mutable.ListBuffer
object Solution extends App {
  def findMissingRanges(
      nums: Array[Int],
      lower: Int,
      upper: Int
  ): List[String] = {
    var mNums = nums.clone()
    val result = ListBuffer[String]()
    val nLen = nums.length
    //modify the array
    if (nLen == 0 || nums.head != lower) {
      mNums = (lower - 1) +: mNums
    }
    if (nLen == 0 || nums.last != upper) {
      mNums = mNums :+ (upper + 1)
    }

    for (i <- 0 until (mNums.length - 1); j = i + 1) {
      val distance = mNums(j) - mNums(i)
      if (distance == 2) result += s"${mNums(j) - 1}"
      if (distance > 2) result += s"${mNums(i) + 1}->${mNums(j) - 1}"
    }

    result.toList
  }
}

/*
G: nums: Array[Int], lower: Int, upper: Int
O: missingRangesList[String]
T: O(n)
S: O(1)

Notes:
  - Given an inclusive range [lower, upper] and a SORTED UNIQUE int array nums
  - All elements in nums are in the inclusive range
  - A number is considered missing if it is in range of [lower, upper], but not in nums
  - Return smallest sorted list of ranges that cover every missing number exactly
  - Each range [a, b] should be output as a->b if a != b and

Ex1:

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"

nums = [0,1,3,50,75], lower = 0, upper = 99

// to update the array, if num(i) is there as the 1st num, keep it, otherwise insert lower -1 as the start
// if the last number is upper, keep it, otherwise insert upper + 1 as the end

missingRange = List("2", "4->49", "51->74", "76-99")

0 1 3 50 75 100
         i
             j

if (nums(j) - nums(i) == 1) {
  // do nothing
} else if (nums(j) - nums(i) == 2) {
  // insert a single number into the missing range list
  nums(j - 1)
} else {
  // more than 2 difference
  list ++ s"${nums(i + 1) -> nums(j - 1)}"
}

i += 1
j += 1

==============================================

Ex2:
Input: nums = [], lower = 1, upper = 1
Output: ["1"]
Explanation: The only missing range is [1,1], which becomes "1".

0 2

2 - 0 = 2

nums(j - 1), which is 2 - 1 which is 1, so List("1")


==============================================
Ex3:

Input: nums = [], lower = -3, upper = -1
Output: ["-3->-1"]
Explanation: The only missing range is [-3,-1], which becomes "-3->-1".

-4 0

0 - -4 = 4, so List(s"${nums(i) + 1 -> nums(j) - 1}"), or List("-3 -> -1")

==============================================
Ex:4
Input: nums = [-1], lower = -1, upper = -1
Output: []
Explanation: There are no missing ranges since there are no missing numbers.

-1

No need to modify the array, we keep it as is.

==============================================
Ex5:
Input: nums = [-1], lower = -2, upper = -1
Output: ["-2"]

-3 -1

List("-2")


 */
