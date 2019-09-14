class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // first let's make sure that s1 is the shorter sintrg
        if (s1.length() > s2.length()) {
            return (checkInclusion(s2, s1));
        }

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            String window = s2.substring(0, s1.length());
            if (isPermutation(window, s1)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPermutation(String window, String pattern) {
        if (window.length() != pattern.length()) {
            return false;
        }
        int[] chars = new int[26]; // number of us letters, will get auto init with all 0s

        for (int i = 0; i < window.length(); i++) {
            chars[window.charAt(i) - 'a']++; // increment for when we find an item in the window
            chars[pattern.charAt(i) - 'a']--; // decrement when we find an item in the pattern
        }

        // let's get through the array and make sure that we do not have any non 0 letters
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
/**
 * Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

a b    e i d b a o o o
                    i j

[0, 0]




 */