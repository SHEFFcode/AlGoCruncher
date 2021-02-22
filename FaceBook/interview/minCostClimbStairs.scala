import scala.collection.mutable.HashMap
object Solution {
  def climbStairs(n: Int): Int = {
    climb(n, HashMap[Int, Int]())
  }

  private def climb(n: Int, brain: HashMap[Int, Int]): Int = {
    if (n < 3) return n
    if (brain.contains(n - 1) && brain.contains(n - 2)) {
      brain(n) = brain(n - 1) + brain(n - 2)
    } else {
      brain(n) = climb(n - 1, brain) + climb(n - 2, brain)
    }
    brain(n)
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
