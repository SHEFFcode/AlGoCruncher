import scala.collection.mutable.HashMap
object Solution extends App {
  def subarraySum(nums: Array[Int], k: Int): Int = {
    val (_, _, count) = nums
      .foldLeft((0, HashMap[Int, Int](0 -> 1), 0)) {
        case ((sumSoFar, brain, totalCnt), cNum) => {
          val cSum = sumSoFar + cNum
          val compliment = cSum - k
          val cCount = totalCnt + brain.getOrElse(compliment, 0)
          brain(cSum) = brain.getOrElse(cSum, 0) + 1
          (cSum, brain, cCount)
        }
      }

    count
  }
  println(subarraySum(Array(1, 2, 3), 3))
}

/*
G: nums: Array[Int], k: Int
O: totalContArrsSumEqualsK: Int
T: ???
S: ???

Notes:
 * Return number of continuous subarrays whose sum equals K

Ex:

[1,1,1], k = 2

count = 1
sumSoFar = 3
{
  0 -> -1
  1 -> 0
  2 -> 1
  3 -> 2
}

compliment = sumSoFar - k

1 1 1  |  k = 2



 */
