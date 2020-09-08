object Solution {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var i = nums1.length - 1 - n
    var j = nums2.length - 1
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

/**
  * Input:
  * nums1 = [1,2,3,0,0,0], m = 3
  * nums2 = [2,5,6],       n = 3
  *
  * var i = nums1.length - n // so we will begin at the end of the array
  * var l = nums1.length
  *
  * [ 1, 2, 3, 0, 0 , 0]
  *         i         l
  * [ 2 , 5 , 6 ]
  *          j
  *
  * we will then compare the "ends" of 2 arrays
  *
  * if (arr2(j) > arr1(i)) {
  *   arr1(l) = arr2(j)
  *   arr1(l - 1) = arr1(i)
  *   l -= 2
  * } else {
  *   arr1(l) = arr1(i)
  *   arr1(l - 1) = arr2(j)
  * }
  */
