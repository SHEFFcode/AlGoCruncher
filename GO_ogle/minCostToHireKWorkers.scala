import scala.collection.mutable.PriorityQueue
object Solution extends App {
  def mincostToHireWorkers(
      quality: Array[Int],
      wage: Array[Int],
      K: Int
  ): Double = {
    val len = quality.length
    val workers = wage
      .zip(quality)
      .sortWith((a, b) =>
        a._1.toDouble / a._2.toDouble < b._1.toDouble / b._2.toDouble
      ) // sorted by wage to quality

    var minCostForK = Double.MaxValue
    var sumQualities = 0
    val qualityQ = PriorityQueue[Integer]() // priority queue

    for (worker <- workers) {
      qualityQ.enqueue(worker._2) // _2 => quality
      sumQualities += worker._2 // increase quality

      if (qualityQ.size > K) {
        // dequeue worker with highest quality
        sumQualities -= qualityQ.dequeue()
      }

      if (qualityQ.size == K) {
        // since we have already sorted the workers, we know this workers ratio is highest
        // of the ones currently in the queue, and we can apply this foruma
        // without fear of underpaying a worker already in the queue
        minCostForK =
          math.min(minCostForK, sumQualities.toDouble * (worker._1 / worker._2))
      }
    }

    minCostForK
  }

  println(mincostToHireWorkers(Array(10, 20, 5), Array(70, 50, 30), 2))
}

/*
G: quality: Array[Int], wage: Array[Int], K: Int
O: minWageExpense: Double
T: Any
S: Any

Notes:
  - K represents the number of workers to be hired
  - Conditions for hiring:
    ^ Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
    ^ Every worker in the paid group must be paid at least their minimum wage expectation.

Ex:

Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.

[10,20,5] | [70,50,30] | 2

wageToQuality: [7, 2.5, 6]


Ex2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately.

[3,1,10,10,1] | [4,8,2,2,7] | k = 3

[12, 8, 20, 20, 7]

 */
