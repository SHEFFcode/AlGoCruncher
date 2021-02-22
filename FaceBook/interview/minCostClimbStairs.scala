object Solution {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val (start1, start2) = (cost.length - 1 to 0 by -1).foldLeft(0, 0) {
      case ((s1, s2), i) => {
        val minCost = cost(i) + (s1 min s2)
        (minCost, s1) // s1 = minCost, s2 = s1
      }
    }
    start1 min start2 // take the min of starting at i or i + 1
  }
}

/*
G: cost: Array[Int]
O: minCost: Int
T: O(n)
S: O(n)

Notes:
  - On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
  - Once you pay the cost, you can either climb one or two steps.
  - You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.


Ex:

 */
