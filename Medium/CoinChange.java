import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * Questions? - Will int[] coins be sorted? - Will it be empty? - Will it
 * contain nulls? - How many coins of each type do I have?
 * 
 * coins = { 1, 2, 5 }, amount 11 * changeToGive: 11 - 5 = 6 - 5 = 1 - 1 = 0
 * coinsUsed: 1, 2, 3 is the changeToGive 0? => yes, stop and return coinsUsed
 * => no, continue with the logic below is highest value coin less then amount
 * still to give? => yes, then use it => no, reduce the current coin and try
 * again
 */

class Solution {
  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    Hashtable<Integer, Integer> cache = new Hashtable<>(coins.length);
    List<Integer> results = new ArrayList<>(coins.length);
    for (int coin : coins) {
      int result = traverse(amount - coin, 1, coins, cache);
      if (result >= 0) {
        results.add(result);
      }
    }
    if (results.size() == 0) {
      return -1;
    }

    return Collections.min(results, null);
  }

  private int traverse(int changeRemaining, int numSteps, int[] coins, Hashtable<Integer, Integer> cache) {
    if (changeRemaining == 0) {
      return numSteps;
    }

    if (changeRemaining < 0) {
      return -1;
    }

    if (cache.containsKey(changeRemaining)) {
      int key = cache.get(changeRemaining);
      return key == -1 ? key : cache.get(changeRemaining) + numSteps;
    } else {
      List<Integer> results = new ArrayList<>(coins.length);
      for (int coin : coins) {
        int result = traverse(changeRemaining - coin, numSteps + 1, coins, cache);
        if (result >= 0) {
          results.add(result);
        }
      }
      if (results.size() == 0) {
        cache.put(changeRemaining, -1);
        return -1;
      }
      int minResult = Collections.min(results, null);
      cache.put(changeRemaining, minResult - numSteps);
      return minResult;
    }
  }
}