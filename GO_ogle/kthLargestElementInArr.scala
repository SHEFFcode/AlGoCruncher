object Solution {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    quickSelect(nums.length - k, nums.toList)

  }

  def quickSelect(k: Int, nums: List[Int]): Int = {
    val pivot = nums.head
    val (less, more) = nums.tail.partition(_ < pivot)
    if (less.length == k) pivot
    else if (k < less.length) quickSelect(k, less)
    else quickSelect(k - less.length - 1, more)
  }

}

/*
G: nums: Array[Int]
O: k: Int
T: Any
S: Any

Notes:
  - kth element in sorted order, not kth distinct

Ex:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

minHeap: [6, 5]

0 1 2 3 4 5
3 2 1 5 6 4
          i

Ex2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

pivot = 3

0 1 2 3 4 5 6 7 8
6 2 3 1 2 4 5 5 3
i

 */
