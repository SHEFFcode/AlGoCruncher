class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        // sort the widths and then longest increasing subseq problem for heights
        Comparator comp = Comparator.comparing((int[] arr) -> arr[0]) // comparing for height will have the smaller height first
                .thenComparing((int[] arr) -> arr[1], Comparator.reverseOrder()); // reverse order here, because we want to have widest to narrowest envelope for max likelyhood of finding the first matching one
        Arrays.sort(envelopes, comp);
        int result = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}

/**
 * This is a similar intuition to stacking boxes:
 *      1) Sort the input based on height, and if same then by width
 *      2) Create a dynamic programming array that is the length of the number of envelopes
 *      3) Compute the number of envelops that can fit into current envelope, and add 1 to it
 * 
 * [[5,4],[6,4],[6,7],[2,3]]
 * 
 * now let's sort by height and width
 * 
 * [[2,3],[5,4],[6,4], [6,7]]
 *     j     i
 * 
 * [1, 1, 1, 1] // DP Array, there will be at least one envelops in each envelope combination
 *      *
 * 
 * 
 * if first envelop can fit in both dimensions into the second one, see how many could fit into the first envelope and add 1 to it.
 * 
 * 
 * 
 * 
 */