object Solution extends App {
  def moveZeroes(nums: Array[Int]): Unit = {
    var z = 0

    for (i <- 0 until nums.length) {
      if (nums(i) != 0) {
        val numsI = nums(i)
        nums(i) = nums(z)
        nums(z) = numsI
        z += 1
      }
    }
  }
}

/*
G: nums: Array[Int]
O: Unit
T: O(n)
S: O(1)

Notes:
  - Move zeros to the end of the array
  - Maintain order of non zero elements
  - Do it in place
  - Minimize number of ops

Ex1:
[0,1,0,3,12] => [1,3,12,0,0]

1 3 0 0 12
    i
        j

 */
