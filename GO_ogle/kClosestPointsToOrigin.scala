import scala.collection.mutable.PriorityQueue
object Solution extends App {
  def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    val squareRoots =
      points.map(x => math.sqrt(math.pow(x(0), 2) + math.pow(x(1), 2)))
    points
      .zip(squareRoots)
      .sortBy(_._2)
      .take(K)
      .map(_._1)
  }

  println(
    scala.runtime.ScalaRunTime.stringOf(
      kClosest(Array(Array(3, 3), Array(5, -1), Array(-2, 4)), 2)
    )
  )
}

/*
G: points: Array[Array[Int]], K: Int
O: kClosestPoints: Array[Array[Int]]
T: ???
S: ???

Notes:
  - Distance is the euclidean distance (pythagorean theorem)
  - You can return the answer in any order
  - Numbers can be positive and negative
  - The starting point is the origin (0, 0)


Ex:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

[[1,3],[-2,2]] | K = 1
 *

1) Calculate the distance
2) Sort by the distance (we can also do this in min heap way.)
3) Take the first k elements

 */
