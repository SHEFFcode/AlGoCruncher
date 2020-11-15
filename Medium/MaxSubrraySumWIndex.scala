object Solution extends App {
  def maxSubArrayIndex(nums: Array[Int]): Array[Int] = {
    // Keep track of max values
    var cMax = 0
    var gMax = 0

    // Keep track of global optimal interval
    var gStart = 0
    var gEnd = 0

    // Keep track of local optimal interval
    var cStart = 0

    nums.zipWithIndex.foreach {
      case (cNum, cEnd) => {
        if (cMax <= 0) {
          cStart = cEnd
          cMax = cNum
        } else {
          cMax += cNum
        }

        if (cMax > gMax) {
          gMax = cMax
          gStart = cStart
          gEnd = cEnd + 1 // to be exclusive
        }
      }
    }
    Array(gMax, gStart, gEnd)
  }

  println(
    scala.runtime.ScalaRunTime.stringOf(
      maxSubArrayIndex(Array(-2, -3, 4, -1, -2, 1, 5, -3))
    )
  )
}

/*
G: nums; Array[Int]
O: maxSubarraySum: Int
T: O(N)
S: O(1)

Notes:
  - Numbers can be positive and negative

 */
