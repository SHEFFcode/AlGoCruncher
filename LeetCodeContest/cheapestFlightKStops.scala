object Solution extends App {
  def findCheapestPrice(
      n: Int,
      flights: Array[Array[Int]],
      src: Int,
      dst: Int,
      K: Int
  ): Int = {
    case class Args(
        edge: Array[Int],
        flightMap: Map[Int, Array[Array[Int]]],
        dst: Int,
        kRemain: Int,
        costSoFar: Int
    )
    def explorePath(arg: Args): Int = {
      if (arg.kRemain < 1) {
        return Int.MaxValue
      }
      if (arg.edge(1) == arg.dst) {
        return arg.costSoFar + arg.edge(2)
      }

      val costAtThisEdge = arg.costSoFar + arg.edge(2)
      val flightsFromEdge = arg.flightMap(arg.edge(0))
      val costOfFlights = flightsFromEdge.map(flight =>
        explorePath(
          Args(flight, arg.flightMap, arg.dst, arg.kRemain - 1, costAtThisEdge)
        )
      )
      costOfFlights.min
    }

    var lowestCost: Int = Int.MaxValue
    var currentLowest: Int = 0

    val flightMap = flights.groupBy(_(0))
    val flightsFromSource = flightMap(src)
    val costs = flightsFromSource.map(flight =>
      explorePath(Args(flight, flightMap, dst, kRemain = K, 0))
    )
    val minCost = costs.min
    if (minCost == Int.MaxValue) -1 else minCost
    println(minCost)
    minCost
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
