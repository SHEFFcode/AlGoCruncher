import scala.collection.mutable.ListBuffer

object Solution {
  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    if (matrix.isEmpty) return 0
    var maxArea = 0
    var cRow = Array.ofDim[Int](matrix(0).length)

    for (i <- 0 until matrix.length) {
      for (j <- 0 until matrix(0).length) {
        // update the state of this row's histogram using the last row's histogram
        // by keeping track of the number of consecutive ones
        if (matrix(i)(j) == '1') cRow(j) += 1 // here += 1
        else cRow(j) = 0 // here = 0, which means just zero out
      }
      // update maxarea with the maximum area from this row's histogram
      maxArea = maxArea max maxHistogramArea(cRow)
    }
    maxArea
  }

  // See largestRectangleInHistogram.scala
  private def maxHistogramArea(cRow: Array[Int]): Int = {
    // cRow serves as the height stack in regular max hist area.
    val posStack = ListBuffer[Int](-1) // position stack
    var maxArea = 0

    for (i <- 0 until cRow.length) {
      while (posStack.head != -1 && cRow(i) < cRow(posStack.head)) {
        val cHeight = cRow(posStack.remove(0))
        val cWidth = i - posStack.head - 1
        maxArea = maxArea max cHeight * cWidth
      }

      i +=: posStack
    }

    while (posStack.head != -1) {
      val cHeight = cRow(posStack.remove(0))
      val cWidth = cRow.length - posStack.head - 1
      maxArea = maxArea max cHeight * cWidth
    }

    maxArea
  }
}

/*
G: matrix: Array[Array[Int]]
O: areaOfLargestRectangle: Int
T: O(nm) n is number of rows, m is the length of row
S: O(M) We allocate an array the size of the the number of columns to store our heights at each row.

Notes:
  - Matrix is filled with 0s and 1s
  - Find largest rectangle (not necessarily a square) containing only 1s

Ex:

 */
