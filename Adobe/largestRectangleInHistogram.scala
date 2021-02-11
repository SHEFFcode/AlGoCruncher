import scala.collection.mutable.ListBuffer
object Solution {
  def largestRectangleArea(heights: Array[Int]): Int = {
    val stack = ListBuffer[Int](-1) // stack class is deprecated, use ListBuffer
    val length = heights.length
    var maxArea = 0
    for (i <- 0 until length) {
      // While the the current height is smaller then the one @ top of stack
      // remove it and calculate the max area.
      while (stack.head != -1 && heights(i) < heights(stack.head)) {
        val cHeight = heights(stack.remove(0))
        val cWidth = i - stack.head - 1
        maxArea = maxArea max cHeight * cWidth
      }
      // once height(i) > stack.head's height, add i to stack
      i +=: stack
    }

    // we've reached the end, if anything is left on the stack, it can
    // give us the best answer, let's check those heights * the full
    // length of the heights arr to see if that's max area.
    while (stack.head != -1) {
      val cHeight = heights(stack.remove(0))
      val cWidth = length - stack.head - 1
      maxArea = maxArea max cHeight * cWidth
    }

    maxArea
  }
}

/*
G: heights: Array[Int]
O: largestArea: Int
T: O(n) n numbers are pushed and popped (so like 2n which is n)
S: O(n) for the stack used which is at most size n

Notes:

Ex:

 */
