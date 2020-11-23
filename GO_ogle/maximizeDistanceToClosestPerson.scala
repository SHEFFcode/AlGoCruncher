import scala.collection.mutable.ArrayBuffer
object Solution extends App {
  def maxDistToClosest(seats: Array[Int]): Int = {
    var distance = 1 // reasonable minimum distance, can't be 0
    val sLen = seats.length
    var i = 0
    var j = 1

    while (j < sLen) {
      if (seats(j) == 1 || j == sLen - 1) {
        val divisor =
          if ((i == 0 && seats(i) == 0) || (j == sLen - 1 && seats(j) == 0)) 1
          else 2
        distance = distance max (j - i) / divisor
        i = j
      }
      j += 1
    }

    distance
  }

  // println(maxDistToClosest(Array(1, 0, 0, 0, 1, 0, 1)))
  println(maxDistToClosest(Array(0, 0, 0, 0, 1, 0, 1)))
  println(maxDistToClosest(Array(1, 0, 1, 0, 0, 0, 0, 0)))
  // println(maxDistToClosest(Array(0, 1)))
}

/*
G: seats: Array[Int]
O: maxDistanceToClosest: Int
T: O(N)
S: O(N)

Notes:
  - At least 1 empty seat
  - At least 1 person sitting
  - What if we start or end with a zero?
    ^ If we begin at zero, we consider it as if it had a 1 before it
    ^ If we end at zero, we consider as if we had a one after it, it might be worth to stick it into the arr


Ex:
Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.

averageDistance = (high - low) / 2 = 0 + (4 - 0) / 2 = 2

0 1 2 3 4 5 6
1 0 0 0 1 0 1
        i
            j


Ex2:
Input: seats = [0,1]
Output: 1

averageDistance = 1

0 1 2
1 0 1
i
    j
 */
