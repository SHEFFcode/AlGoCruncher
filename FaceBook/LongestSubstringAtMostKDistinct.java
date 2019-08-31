import java.util.Map;

class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s.length() == 0 || k == 0) {
      return 0;
    }

    int start = 0, end = 0;
    int longestDistinctK = 0;
    Map<Character, Integer> occuranceCounter = new HashMap<>();

    while (end < s.length()) { // DANGER ZONE, make sure to increment end
      char endChar = s.charAt(end);
      occuranceCounter.merge(endChar, 1, Integer::sum);

      while (occuranceCounter.size() > k) {
        char startChar = s.charAt(start);

        int occuranceCount = occuranceCounter.get(startChar);
        if (occuranceCount - 1 == 0) {
          occuranceCounter.remove(startChar);
        } else {
          occuranceCounter.put(startChar, occuranceCount - 1);
        }

        start++;
      }

      longestDistinctK = Math.max(longestDistinctK, end - start + 1);
      end++;
    }

    return longestDistinctK;
  }
}

/**
 * Better solution
 */

class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int distinctCount = 0;
    int[] occuranceCounter = new int[256];
    int start = 0;
    int longestDistinctK = 0;

    for (int end = 0; end < s.length(); end++) {
      char endChar = s.charAt(end);

      if (occuranceCounter[endChar] == 0) {
        distinctCount++;
      }

      occuranceCounter[endChar]++;

      while (distinctCount > k) {
        char startChar = s.charAt(start);

        occuranceCounter[startChar]--;

        if (occuranceCounter[startChar] == 0) {
          distinctCount--;
        }

        start++;
      }

      longestDistinctK = Math.max(longestDistinctK, end - start + 1);
    }

    return longestDistinctK;
  }
}

/**
 * s = "e c e b a", k = 2 => 3 i j
 * 
 * { e: 2, c: 1, }
 * 
 * we want to basically have an idea of which character has the highest and
 * second highest frequency, but in a way that they are one after another.
 * 
 * Key is to realize that we can have a greedy algo here, where we keep two
 * pointers, i and j and a dictionary where we move j forward for as long as
 * dictionary size is less then 2, as long as it's more then 2 we move i forward
 * decrementing the value for that key until we reach zero and delete the key
 * from dictionary
 */