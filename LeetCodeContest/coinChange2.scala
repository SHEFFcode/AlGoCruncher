import scala.collection.mutable.HashSet

/**
  *    Input: amount = 5, coins = [1, 2, 5]
  *    Output: 4
  *    Explanation: there are four ways to make up the amount:
  *    5=5
  *    5=2+2+1
  *    5=2+1+1+1
  *    5=1+1+1+1+1
  *
  *    G: amount: Int, coins: Array[Int]
  *    O: numberOfWays: Int
  *    T: Any
  *    S: Any
  *
  * amount = 5, coins = [1, 2, 5]
  *
  * [1, 2, 5]
  *
  * we also need to have a reference map if the solutions
  *
  * This is exhaustive search, which lends itself to backtracking algorithms
  * We will do choose, explore, unchoose methodology
  *
  *                 () [1, 2, 5]
  *             /    |      \
  *           1      2      5
  *         1 2 5  1 2 5   1 2 5
  *
  * Base cases:
  * 1) Total so far is > amount => return 0 from the function
  * 2) Total so far is == amount => return 1 from the function
  */

import scala.collection.mutable.HashMap

import scala.collection.mutable.HashMap

object Solution {
  def change(amount: Int, coins: Array[Int]): Int = {
    val brain = new HashMap[String, Int]()

    def exhaustiveSearch(
        coinIndex: Int,
        remainder: Int,
        brain: HashMap[String, Int]
    ): Int = {
      if (remainder == 0) {
        return 1 // we found another solution
      }

      if (coinIndex == coins.size) {
        return 0
      }

      if (remainder < 0) {
        return 0
      }

      val key = s"${coinIndex}:${remainder}"

      if (brain.contains(key)) {
        return brain(key)
      }
      val numberOfWaysUsingCoin = exhaustiveSearch(
        coinIndex,
        remainder - coins(coinIndex),
        brain
      ) // use current coin
      val numberOfWaysNotUsingCoin = exhaustiveSearch(
        coinIndex + 1,
        remainder,
        brain
      ) // don't use current coin
      var numberOfWays = numberOfWaysUsingCoin + numberOfWaysNotUsingCoin
      brain += (key -> numberOfWays)
      return brain(key)
    }

    return exhaustiveSearch(0, amount, brain)
  }
}
