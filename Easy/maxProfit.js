/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let buyLow = prices[0], profit = 0;

for (let i = 1; i < prices.length; i++) {
    profit = prices[i] - buyLow > profit ? prices[i] - buyLow : profit;
    if (prices[i] < buyLow) {
        buyLow = prices[i];
    }
} 

return profit > -1 ? profit : 0;
};

/*
G: int[] prices
O: int max profit
T: Any
S: Any

Notes:
* Only allowed to compelte one trasaction

Edge Cases:
* What if the stock keeps falling in value, so you profit is a loss? => return 0
* what if there is only one value in the array? => not possible, assume that does not happen

Solution:
Case1: !buyLow, buyLow = Math.min(sellHigh,current)
Case2: !sellHigh, sellHigh = Math.max(buyLow, current)
Case3: both buyLow && sellHigh:
profit = Math.max(sellHigh - buyLow, profit)
return profit



ex: [7, 1, 5, 3, 6, 4] => 5

1
profit = 5

buyLow = 7, 1
sellHigh = 6
profit = 5

*/
