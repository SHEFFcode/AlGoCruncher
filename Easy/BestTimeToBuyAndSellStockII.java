import java.util.stream.IntStream;

class Solution {
  public int maxProfit(int[] prices) {
    return IntStream.range(1, prices.length).map(i -> Math.max(prices[i] - prices[i - 1], 0)).sum();
  }
}