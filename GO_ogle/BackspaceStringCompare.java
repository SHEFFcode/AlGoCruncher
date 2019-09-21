class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] sChars = transformChars(S.toCharArray());
        char[] tChars = transformChars(T.toCharArray());

        for (int i = 0, j = 0; i < sChars.length && j < tChars.length; i++, j++) {
            while (i < sChars.length && (sChars[i] == '#' || sChars[i] == '.')) {
                i++;
            }

            while (j < tChars.length && (tChars[j] == '#' || tChars[j] == '.')) {
                j++;
            }

            if (i == sChars.length || j == tChars.length) {
                return i == sChars.length && j == tChars.length;
            }

            if (sChars[i] != tChars[j]) {
                return false;
            }
        }

        return true;
    }

    private char[] transformChars(char[] chars) {
        int dotCount = 0;
        // let's traverse these puppies in reverse
        for (int i = chars.length - 1; i > -1; i--) {
            if (chars[i] == '#') {
                dotCount++;
            } else if (dotCount > 0) {
                chars[i] = '.';
                dotCount--;
            }
        }

        return chars;
    }
}
/**
 *  Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".

    a . # c         |            a . # c
    i
                                 i


    . . # #    . # . # 
      i
               i




    . # # c  # . # c 
    i
            j


    . # c    |    b
    i  
                  j


    dotCount = 0


    on the forward pass on the strings we skip the dots and ##s

    What if we just modify the array and then do a string compare?
    
    
    // do this for both strings
    for (S.length(), 0) { // let's go in reverse
        if (charAt(i) == '#') {
            dotCount++;
        } else if (dotCount > 0) {
            S.charAt(i) = '.';
        }
    }


    // not let's traverse both
    for (i < S.length(), j < T.length()) {
        while (S.charAt(i) == '#' || S.CharAt(j) == '.') {
            i++;
        }

        while (T.charAt(j) == '#' || T.charAt(j) == '.') {
            j++;
        }

        if (S.charAt(i) != T.charAt(j)) {
            return false;
        }
    }

    return true;



 */