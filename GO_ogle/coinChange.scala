object Solution {
  val NO_REMAINDER = 0
  val NO_CHANGE_POSSIBLE = -1
  def coinChange(coins: Array[Int], amount: Int): Int = {
    traverse(coins, amount, Array.fill[Int](amount + 1)(0))
  }

  private def traverse(
      coins: Array[Int],
      amount: Int,
      brain: Array[Int]
  ): Int = {
    if (amount == 0) NO_REMAINDER
    else if (amount < 0) NO_CHANGE_POSSIBLE
    else if (brain(amount) != 0) brain(amount)
    else {
      val minSteps = coins.foldLeft(Int.MaxValue) {
        case (minSteps, coin) => {
          val res = traverse(coins, amount - coin, brain)
          if (res >= 0 && res < minSteps) res + 1
          else minSteps
        }
      }

      brain(amount) = if (minSteps == Int.MaxValue) -1 else minSteps
      brain(amount)
    }
  }
}

/*
G: coins: Array[Int], amount: Int
O: minCoinsToMakeChange: Int
T: O(A * C) (amount stack frames + coin count operations at each level)
S: O(A) the brain will be of size A

Notes:
  - Write a function to compute the fewest number of coins that you need to make up that amount.
  - If that amount of money cannot be made up by any combination of the coins, return -1.
  - You may assume that you have an infinite number of each kind of coin.

Ex:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

 */
