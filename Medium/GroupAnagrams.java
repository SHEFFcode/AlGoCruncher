import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> stringListHashMap = new HashMap<>();

    for (final String anagram : strs) {
      char[] anagramChars = anagram.toCharArray();
      Arrays.sort(anagramChars);

      stringListHashMap.merge(String.valueOf(anagramChars), new ArrayList<>(Arrays.asList(anagram)),
          (oldValue, newValue) -> {
            oldValue.add(anagram);
            return oldValue;
          });
    }

    return new ArrayList<>(stringListHashMap.values());
  }
}