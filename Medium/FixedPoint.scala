object Solution {
    def fixedPoint(A: Array[Int]): Int = {
        def binarySearch(start: Int, end: Int) = {
          val mid = start + (end - start) / 2
          if (start > end) -1
          else if (A(mid) == mid) mid
          else if (A(mid) > mid) binarySearch(start, mid - 1)
          else binarySearch(mid + 1, end)
        }

        binarySearch(0, A.length - 1)
    }
}