import java.io.*;
import java.util.*;

class Solution {

  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    // your code goes here
    Map<String, String> flattenedDictionary = new HashMap<>(); // we don't know the size yet
    flattenHelper(dict, flattenedDictionary, new StringBuilder()); // TODO: Fille out the inputs there
    return flattenedDictionary;
  }

  private static void flattenHelper(Map<String, Object> dictionarySubset, Map<String, String> flattenedDictionary,
      StringBuilder prefix) {
    for (String key : dictionarySubset.keySet()) {
      if (dictionarySubset.get(key) instanceof String) {
        flattenedDictionary.put(prefix.toString(), (String) dictionarySubset.get(key));
      } else {
        if (key.length() > 0) {
          prefix.append("." + key);
        }
        flattenHelper((Map<String, Object>) dictionarySubset.get(key), flattenedDictionary, prefix);
      }
    }
  }

  public static void main(String[] args) {

  }

}