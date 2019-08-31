class Solution {
  public boolean validPalindrome(String s) {
    int i = 0, j = s.length();
    int skippedCount = 0;

    while (i < j && skippedCount < 2) { // DANGER ZONE, make sure these values change
      if (s.charAt(i + 2) == s.charAt(j - 1)) {
        i++;
        skippedCount++;
      } else if (s.charAt(i + 1) == s.charAt(j - 2)) {
        j--;
        skippedCount++;
      } else {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }
}

/**
 * You can delete at most 1 character, so instead of deleting we will simply
 * skip it a b a => true i j
 * 
 * skippedCount if i >= j return true
 * 
 * 
 * a b c d b a i j
 * 
 * while (i < j && skippedCount < 2) if (s[i] == s[j]) i++ j-- else if (s[i + 2]
 * == s[j - 1]) i++ skippedCount++; else if (s[i + 1] == s[j - 2]) j--
 * skippedCount++ else return false
 * 
 */