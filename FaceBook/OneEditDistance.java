class Solution {
  public boolean isOneEditDistance(String s, String t) {
    int shortString = s.length();
    int longString = t.length();

    // Ensure that s is shorter than t.
    if (shortString > longString)
      return isOneEditDistance(t, s);

    // The strings are NOT one edit away distance
    // if the length diff is more than 1.
    if (longString - shortString > 1)
      return false;

    for (int i = 0; i < shortString; i++)
      if (s.charAt(i) != t.charAt(i))
        // if strings have the same length
        if (shortString == longString)
          return s.substring(i + 1).equals(t.substring(i + 1));
        // if strings have different lengths
        else
          return s.substring(i).equals(t.substring(i + 1));

    // If there is no diffs on ns distance
    // the strings are one edit away only if
    // t has one more character.
    return (shortString + 1 == longString);
  }
}