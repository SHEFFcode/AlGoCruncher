object Solution {
  def maxArea(height: Array[Int]): Int = {
    def findMaxArea(start: Int, end: Int, maxArea: Int): Int = {
      if (start == end) return maxArea
      val cArea = Math.min(height(start), height(end)) * (end - start)
      val newMax = Math.max(cArea, maxArea)
      if (height(end) > height(start)) findMaxArea(start + 1, end, newMax)
      else findMaxArea(start, end - 1, newMax)
    }
    findMaxArea(0, height.length - 1, 0)
  }
}