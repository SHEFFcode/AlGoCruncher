object Solution {
  val x1 = 0
  val y1 = 1
  val x2 = 2
  val y2 = 3
  def isRectangleOverlap(rec1: Array[Int], rec2: Array[Int]): Boolean = {
    // check if the rectangle is a line
    if (
      rec1(x1) == rec1(x2) ||
      rec1(y1) == rec1(y2) ||
      rec2(x1) == rec2(x2) ||
      rec2(y1) == rec2(y2)
    ) return false // if so return false

    // else make sure that x and y values of the rectangles all intersect
    rec1(x1) < rec2(x2) &&
    rec1(y1) < rec2(y2) &&
    rec2(x1) < rec1(x2) &&
    rec2(y1) < rec1(y2)
  }
}

/*
G: rec1: Array[Int], rec2: Array[Int]
O: doRectanglesOverlap: Boolean
T: O(1)
S: O(1)

Notes:
  - To be clear, two rectangles that only touch at the corner or edges do not overlap.

Ex:
Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true

 */
