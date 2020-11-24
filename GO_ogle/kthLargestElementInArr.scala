import scala.util.Random
object Solution extends App {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    select(0, nums.length - 1, nums.length - k, nums)
  }

  def partition(left: Int, right: Int, pIdx: Int, nums: Array[Int]): Int = {
    val pivot = nums(pIdx) // let's keep track of it

    // move pivot to end of current range
    swap(right, pIdx, nums)

    // move all smaller elements to the left
    var storeIdx = left
    for (i <- left until right) {
      if (nums(i) < pivot) {
        swap(storeIdx, i, nums)
        storeIdx += 1
      }
    }

    // move pivot to its final place
    swap(right, storeIdx, nums)

    storeIdx
  }

  def swap(a: Int, b: Int, arr: Array[Int]): Unit = {
    val arrA = arr(a)
    arr(a) = arr(b)
    arr(b) = arrA
  }

  def select(left: Int, right: Int, kSmallest: Int, nums: Array[Int]): Int = {
    if (left == right) return nums(left) // if 1 item, return it
    val randomIdx = left + new Random().nextInt(right - left)
    val pivotIdx = partition(left, right, randomIdx, nums)

    if (kSmallest == pivotIdx) nums(kSmallest)
    else if (kSmallest < pivotIdx) select(left, pivotIdx - 1, kSmallest, nums)
    else select(pivotIdx + 1, right, kSmallest, nums)
  }

  println(findKthLargest(Array(3, 2, 1, 5, 6, 4), 2))
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
