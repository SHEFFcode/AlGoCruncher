class Solution {
    public boolean isMatch(String s, String p) {
        Bool[][] memoization = new int[s.length() + 1][p.length() + 1];
        memoization[0][0] = Bool.TRUE;

        buildUpTheArray(0, 0, s, p, memoization);

        return memoization[s.length() - 1][p.length() - 1];
    }

    private boolean buildUpTheArray(int i, int j, String str, String pattern, Bool[][] memoization) {
        if (memoization[i][j] != null) { // we have computed this result already
            return memoization[i][j] == Bool.TRUE; // return the result from memoization
        }
        boolean currentValue = false;
        if (j == pattern.length()) { // if we matched up to this point in the pattern, let's confirm we've reached
                                     // the end of the string as well
            currentValue = i == str.length();
        } else {

        }

    }
}

enum Bool {
    TRUE, FALSE
}