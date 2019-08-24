class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();

    int[] charCount = new int[26];

    for (int i = 0; i < s.length(); i++) {
      char sChar = sChars[i];
      char tChar = tChars[i];

      charCount[sChar - 'a']++; // to get to zero index.
      charCount[tChar - 'a']--;
    }

    for (int c : charCount) {
      if (c != 0) {
        return false;
      }
    }

    return true;
  }
}