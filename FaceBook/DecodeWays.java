import java.util.Arrays;

class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length() + 1]; // we want to account for empty string here, so we will go 1 longer then
                                               // string
        Arrays.fill(cache, -1); // we will fill with -1 because that will indicate unexplored values
        cache[s.length()] = 1; // for empty string we will return 1 by definition
        return decode(s, 0, cache);
    }

    private int decode(String s, int index, int[] cache) {
        /**
         * If we already have a solution for this index, we will return it from the
         * cache
         */
        if (cache[index] != -1) { // this is both our goal and our base case.
            return cache[index];
        }

        char cChar = s.charAt(index); // let's take down the current character
        if (cChar == '0') {
            /**
             * there are not ways to decode 0, so all numbers after 0 are disregarded,
             * unless we had something like a 10 or a 20 where these are valid numbers and
             * we sort of skip anything that starts with 0. If we have 560231321 it will be
             * zero, since 56 cannot be a number and 0 cannot begin a sequence
             */
            return 0; // this is a constraint
        }

        int result = decode(s, index + 1, cache); // the result will be decode (k + 1) + decode (k + 2), but only
                                                  // if k + 2 is within the constraints
        if (s.length() - index >= 2 && Integer.valueOf(s.substring(index, index + 2)) <= 26) { // this is
            // another
            // constraint
            result += decode(s, index + 2, cache);
        }

        cache[index] = result; // update the cache
        return result; // return the result
    }
}