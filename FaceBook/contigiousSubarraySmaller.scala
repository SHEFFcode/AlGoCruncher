// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object ContiguousSubarrays {

  def main(args: Array[String]) {
    // Call countSubarrays() with test cases here
    val res = countSubarrays(Array(3, 4, 1, 6, 2))
    println(s"Res: ${scala.runtime.ScalaRunTime.stringOf(res)}")
  }

  def countSubarrays(arr: Array[Int]): Array[Int] = {
    // Write your code here
    val len = arr.length

    (0 until len).foldLeft(Array.ofDim[Int](len)) {
      case (result, idx) => {
        val num = arr(idx)
        val leftSide = arr.slice(0, idx).reverse
        val rightSide = arr.slice(idx + 1, len)

        val leftMaxLen = leftSide.takeWhile(_ < num).length
        val rightMaxLen = rightSide.takeWhile(_ < num).length
        result(idx) = leftMaxLen + rightMaxLen + 1
        result
      }
    }
  }
}

/*
You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfill the following conditions:
The value at index i must be the maximum element in the contiguous subarrays, and
These contiguous subarrays must either start from or end on index i.
Signature
int[] countSubarrays(int[] arr)
Input
Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
Size N is between 1 and 1,000,000
Output
An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
Example:
arr = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]
Explanation:
For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 - [1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
So, the answer for the above input is [1, 3, 1, 5, 1]
 */
