object Solution {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val m = matrix.length
    if (m == 0) return false // if no width target not there
    val n = matrix(0).length

    var left = 0
    var right = m * n - 1 // basically flattens the matrix
    var mid: Int = 0
    var midEl = 0

    while (left <= right) {
      mid = left + (right - left) / 2
      // row is mid / n rounded down
      // col is mid % n
      midEl = matrix(mid / n)(mid % n)
      if (target == midEl) return true
      else {
        if (target < midEl) {
          // look in the left half of the flattened list
          right = mid - 1
        } else {
          // look in the right half of flattened list
          left = mid + 1
        }
      }
    }
    // didn't find it, so return false
    false
  }
}

/*
G: matrix: Array[Array[Int]], target: Int
O: existsInMatrix: Boolean
T: Log(n)
S: O(1)

Notes:
  - Integers in each row are sorted from left to right.
  - The first integer of each row is greater than the last integer of the previous row.

Ex:

 */

/*
G: matrix: Array[Array[Int]], target: Int
O: existsInMatrix: Boolean
T: Log(n)
S: O(1)

Notes:
  - Integers in each row are sorted from left to right.
  - The first integer of each row is greater than the last integer of the previous row.

Ex:

 */
