import java.util.ArrayList;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIndexies = new ArrayList<>(s.length()); // conservatively reasonable size
        if (s.length() == 0 || p.length() == 0) {
            return anagramIndexies;
        }
        Map<Character, Integer> characterMap = new HashMap<>(s.length()); // reasonable size

        for (char c : p.toCharArray()) {
            characterMap.merge(c, 1, Integer::sum);
        }

        int charsToSatisfy = characterMap.size(); // this will hold how many characters we still need to find in our window of s

        for (int i = 0, j = i + (p.length() - 1); j < s.length(); i++) {
            if ()
        }



    }
}

/**
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * c b a e b a b a c d a b c i j
 * 
 * 
 * { a: 1 b: 0 c: 1 }
 * 
 * lettersNeededToAdd = 1 lettersNeededToRemove = 0 anagram index = i [0, 6]
 * 
 */