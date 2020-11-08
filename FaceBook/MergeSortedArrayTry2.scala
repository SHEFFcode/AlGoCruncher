object Solution extends App {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var i = m - 1
    var j = n - 1
    var l = nums1.length - 1

    for (l <- nums1.length - 1 until 0 by -1) {
      if (nums2(j) > nums1(i)) {
        nums1(l) = nums2(j)
        j -= 1
      } else {
        nums1(l) = nums1(i)
        i -= 1
      }
    }
  }
}

/*
G: nums1: Array[Int], nums2: Array[Int], m: Int, n: Int
O: nums1: Array[Int]
T: O(n)
S: O(1)

Notes:
  - m is the length of nums1
  - n is the length of nums2
  - Goal is to return nums 1 that is modified to include nums2 elements and sorted
  - Assume nums1 has enough space to include all of its own and num2's elements in it

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

[1,2,2,3,5,6]
   i
     l
[2,5,6]
j
 */
