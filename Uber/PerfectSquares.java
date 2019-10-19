class Solution {

    public int numSquares(int n) {
        int dp[] = new int[n + 1]; // this will contain all the numbers in a given range.
        Arrays.fill(dp, Integer.MAX_VALUE); // their initial values will be max values
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1; // the max square that we will need is the result of sqrt(n)
        int square_nums[] = new int[max_square_index]; // let's calculate what those numbers are
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i; // [0, 1, 4, 9, 16, 25] etc
        }

        for (int i = 1; i <= n; ++i) { // numbers from 1 to 25 for example to build a bottom up solution
            for (int s = 1; s < max_square_index; ++s) { // numbers from 1 to 25 that are squares of their indexes
                if (i < square_nums[s]) // this would result in a negative number lookup below, so let's skip those
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1); // the result is the min of what's already in dp for that i, or subtract from dp's index the closes lower square and add 1 to that precalculated result
            }
        }
        return dp[n];
    }
}

/**
 * Key insights:
 *  - we can have a solution where we need just 1 number, which is a number that is a square root of n multiplied by itself
 *      Therefore, the number of squares that we can have in our solution is bounded by sqrt(n)
 *  - in order to get the final solution, we need to explore and find solution to all the previous numbers, and since 1 is also a perfect
 *      square, the solution will be the result of min of (previously calculated solution for cIndex + 1, previously calculated solution for (n - previous square) + 1)
 *      this again only works because 1 is a perfect square
 * 
 * 
 * n = 25
 * 
 * 
 * dp = [0, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]
 * 
 * max_square_index = sqrt(25) = 5
 * 
 * square_nums = [1, 4, 9, 16, 25]
 * 
 * 
 * 
 * now we will calculate all the numbers
 * 
 * 
 * [0, 1, 2, 3, 1, 5, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]
 *                 i
 *      [0, 1, 4, 9, 16, 25]
 *          j
 */