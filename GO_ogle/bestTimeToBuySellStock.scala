object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    val (_, maxProf) = prices.foldLeft(Int.MaxValue, 0) {
      case ((minPrice, maxProf), cPrice) => {
        if (cPrice < minPrice) (cPrice, maxProf)
        else if (cPrice - minPrice > maxProf) (minPrice, cPrice - minPrice)
        else (minPrice, maxProf)
      }
    }
    maxProf
  }
}

/*
G: prices: Array[Int]
O: bestTime: Int
T: O(N)
S: O(N)

Notes:
  - an array for which the ith element is the price of a given stock on day i.
  - If you were only permitted to complete at most one transaction
  - design an algorithm to find the maximum profit.
  - Note that you cannot sell a stock before you buy one.

Ex:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

minVal = 1
maxProfit = 6

7 1 5 3 6 4
            i

Ex2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

minVal = 1
maxProfit = 0

7 6 4 3 1
          i

 */
