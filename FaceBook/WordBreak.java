import java.util.Map;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0) { // basics here, per definition
            return false;
        }
        Map<String, Boolean> cache = new HashMap<>(s.length()); // reasonable size
        Set<String> wordSet = new HashSet<>(wordDict); // we don't want any duplicates

        return breakUpWord(s, wordSet, cache);
    }

    private boolean breakUpWord(String s, Set<String> wordSet, Map<String, Boolean> cache) {
        if (cache.containsKey(s)) { // if we already have an answer, let's return it
            return cache.get(s);
        }

        if (wordSet.contains(s)) { // if a word is in the dictionary, let's update the cache and return true
            cache.put(s, true);
            return true;
        }

        /**
         * Here we are looking through all the possible word split points, skipping ones
         * where the suffix cannot be a word. Since we need to decode the whole string,
         * it's vital that there is a suffix that is in the dictionary. If there is no
         * length suffix that is in the dictionary, then the current substring cannot be
         * made up of words in the dictionary, and we note that in the cache and return
         * false.
         */

        for (int i = 0; i < s.length(); i++) {
            String rightSubstring = s.substring(i);

            if (!wordSet.contains(rightSubstring))
                continue;
            cache.put(rightSubstring, true);

            if (breakUpWord(s.substring(0, i), wordSet, cache)) {
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }
}

/**
 * Map<String, Boolean> cache
 * 
 * { code: true }
 * 
 * runtime O(length of word) space O(length of word)
 * 
 * s = "leetcode", wordDict = ["leet", "code"]
 * 
 * leetcode
 * 
 * l + eetcode || le + etcode || lee + tcode || leet + code || leetc + ode ||
 * leetco + de || leetcod + e || leetcode e + etcode + ee + tcode
 * 
 */