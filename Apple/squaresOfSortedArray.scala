object Solution {
  def sortedSquares(nums: Array[Int]): Array[Int] = {
    val len = nums.length
    val res = Array.ofDim[Int](len)
    var left = 0
    var right = len - 1

    for (i <- len - 1 to 0 by -1) {
      var square: Int = 0
      if (math.abs(nums(left)) < math.abs(nums(right))) {
        square = nums(right)
        right -= 1
      } else {
        square = nums(left)
        left += 1
      }

      res(i) = square * square
    }

    res
  }
}

/*
G: nums: Array[Int]
O: sortedSquare: Array[Int]
T: O(n)
S: O(n)

Notes:

Ex:

 */
