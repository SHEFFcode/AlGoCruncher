object Solution extends App {
  def findCheapestPrice(
      n: Int,
      flights: Array[Array[Int]],
      src: Int,
      dst: Int,
      K: Int
  ): Int = {
    def explorePath(
        edge: Array[Int],
        flightMap: Map[Int, Array[Array[Int]]],
        dst: Int,
        kRemain: Int,
        costSoFar: Int
    ): Int = {
      if (kRemain < 0) {
        return Int.MaxValue
      }
      if (edge(1) == dst) {
        return costSoFar + edge(2)
      }

      val costAtThisEdge = costSoFar + edge(2)
      if (flightMap.exists(_._1 == edge(1))) {
        val flightsFromEdge = flightMap(edge(1))
        println(
          s"flights from edge are ${scala.runtime.ScalaRunTime.stringOf(flightsFromEdge)}"
        )
        val costOfFlights = flightsFromEdge.map(flight =>
          explorePath(
            flight,
            flightMap,
            dst,
            kRemain - 1,
            costAtThisEdge
          )
        )
        println(
          s"Cost of flights at this stage is ${scala.runtime.ScalaRunTime.stringOf(costOfFlights)}"
        )
        costOfFlights.min
      } else {
        Int.MaxValue
      }

    }

    val flightMap = flights.groupBy(_(0))
    if (flightMap.exists(_._1 == src)) {
      val flightsFromSource = flightMap(src)
      val costs = flightsFromSource.map(flight =>
        explorePath(flight, flightMap, dst, kRemain = K, 0)
      )
      val minCost = costs.min
      if (minCost == Int.MaxValue) -1 else minCost
      println(s"The mininmum cost is ${minCost}")
      minCost
    } else {
      -1
    }
  }

  findCheapestPrice(
    3,
    Array(Array(0, 1, 100), Array(1, 2, 100), Array(0, 2, 500)),
    0,
    2,
    2
  )
}

/*
G: n: Int <- numberOfCities, edges: Array[Array[Int]] <- cost of flights between nodes, src: Int <- starting node, dst: Int <- destination, k: Int <- # stops
O: cost: Int <- lowest cost with specified number of stops // this usually means exhaustive search with choose, explore unchoose approach
T: Any
S: Any


more of less this looks like a graph traversal algo

n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1

[[0,1,100],[1,2,100],[0,2,500]]

------------------------------------------------

{
  0: [0, 1, 100], [0, 2, 500],
 *
  1: [1, 2, 100]
 *
}

kRemaining: 1
totalSoFar: 0 + 500
lowestTotal = 200



------------------------------------------------
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0

{
  0: [0, 1, 100], [0, 2, 500],
 *
  1: [1, 2, 100]
 *
}

kRemaining: 0
totalSoFar: 0 + 500
lowestTotal = 500
 */
