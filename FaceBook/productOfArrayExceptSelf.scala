object Solution {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val result = Array.fill(nums.length)(1)

    for (i <- 1 until nums.length) {
      result(i) = result(i - 1) * nums(i - 1)
    }
    (nums.length - 1 to 0 by -1).foldLeft(1) { (acc, i) =>
      {
        result(i) = result(i) * acc
        acc * nums(i)
      }
    }

    result
  }
}

/*
nums [ 1, 2, 3, 4 ]
        i

[1, 1, 2, 6]
answer [ 24, 12, 8, 6 ]
         i


rightProduct = 24
 */
