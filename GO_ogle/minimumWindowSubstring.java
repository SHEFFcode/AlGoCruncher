/**
 * Input: S = "ADOBECODEBANC", T = "ABC" i j Output: "BANC"
 * 
 * length = 4
 * 
 * { A: t B: t C: f }
 * 
 * 
 * [11, 13]
 * 
 * count found = 2
 * 
 * as soon as j comes off the array we see the end result.
 */

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";

        Map<Character, Integer> map = new HashMap<>(t.length()); // sensible default size
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int start = 0, end = 0;
        int count = t.length();
        int minLength = s.length() + 1, minLeft = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0)
                    count--;

                while (count == 0) { // valid
                    if (end - start + 1 < minLength) {
                        minLength = end - start + 1;
                        minLeft = start;
                    }

                    c = s.charAt(start);
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                        if (map.get(c) > 0)
                            count++; // make it invalid
                    }

                    start++;
                }
            }
            end++;
        }

        return minLength == s.length() + 1 ? "" : s.substring(minLeft, minLeft + minLength);
    }
}