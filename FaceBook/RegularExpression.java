class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] tabulation = new boolean[s.length() + 1][p.length() + 1]; // we want an extra row and column for
                                                                              // empty string or pattern
        tabulation[0][0] = true; // if both the string and the pattern are empty strings, we return true

        /**
         * We have to populate the first horizontal and vertical rows which deal with
         * cases where either the string or the pattern is empty. Here if pattern is
         * empty, we can never get true, so that first column will be false all the way
         * down. If the string is empty however, the pattern can still return true, for
         * example "" compared with "a*" will return true, as start means 0 or more
         * occurences of that character. How do we fill out that row, if we see a *, we
         * check 2 chars before the star, to see whether that character was true, and if
         * so we set it to true, if not we set it to false.
         */

        for (int j = 1; j < p.length() + 1; j++) { // why p.length() + 1? Because our row is wider then pattern by 1
            char cChar = p.charAt(j - 1); // why j - 1, because j here starts at 1, so it's 1 ahead of the cChar
                                          // position in pattern
            if (cChar == '*') {
                /**
                 * Why am I sure that there will be i - 2? Because the first item in row is
                 * always filled up with true per tabulation[0][0] above, and * cannot come
                 * before character that it adds * behavior to
                 */
                tabulation[0][j] = tabulation[0][j - 2];
            }
        }

        /**
         * Our goal here is to use tabulation matrix to come up with every subproblem
         * based on results seen so far, and then return the global solution in the
         * bottom right of the matrix
         */

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                char sChar = s.charAt(i - 1); // i is always one ahead of sChar position
                char pChar = p.charAt(j - 1); // j is always one ahead of pChar position

                if (pChar == '.' || sChar == pChar) {
                    /**
                     * If our pChar is a '.' it will match with any sChar. So if the two match, the
                     * string at this position will only match the pattern if the string up to this
                     * position matched the pattern as well. We can check that by checking the
                     * tabulated values [i - 1][j - 1], as they hold the answer as to whether the
                     * string up to previous characters in s and p matched.
                     */
                    tabulation[i][j] = tabulation[i - 1][j - 1];
                } else if (pChar == '*') {
                    /**
                     * This is the same as what we did for populating the 0th row above, but there
                     * is a bit of a twist since our string is no longer assumed empty, we must
                     * check whether or not the char in pattern at position one before the * matches
                     * with the char in string at current position.
                     */
                    tabulation[i][j] = tabulation[i][j - 2]; // this tests for cases of * where we take 0 occurences
                    /**
                     * If we need to try multiple occurences of any char, or multiple occurences of
                     * a char in pattern that matches the string, we can add get another true if one
                     * or more occurences of that p.charAt(j - 2) would make the expression match,
                     * which basically means in the case of pChar being * that the pattern so far
                     * without any * chars matches the string so far wihtout current sChar
                     */
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == sChar) {
                        tabulation[i][j] = tabulation[i][j] || tabulation[i - 1][j];
                    }
                } else {
                    /**
                     * Pretty basic case here, we simply do not have any wildcard character and the
                     * chars do not match, this is simply false, not ifs or buts about it
                     */
                    tabulation[i][j] = false;
                }
            }
        }

        return tabulation[s.length()][p.length()];
    }

}