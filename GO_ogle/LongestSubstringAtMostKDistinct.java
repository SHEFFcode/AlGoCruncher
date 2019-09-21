class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int begin, end;

        for (begin = 0, end = 0; end < s.length(); end++) {
            map.merge(s.charAt(end), 1, Integer::sum);
            if (map.size() > 2) {
                max = Math.max(max, end - begin); // to fix zero based indexing
                while (map.size() > 2) { // Danger zone, make sure this changes
                    int previousLengthForKey = map.get(s.charAt(begin));
                    int newLengthForKey = previousLengthForKey - 1;
                    map.merge(s.charAt(begin), 0, (oldVal, newVal) -> oldVal - 1);
                    if (newLengthForKey == 0) {
                        map.remove(s.charAt(begin)); // this solves the issue of map size reduce
                    }
                        
                    begin++;
                }
            }
        }
        
        return Math.max(max, end - begin); // in case we go through the whole thing with just 2 distinct chars
    }
}

/**
 * Input: "eceba"
    Output: 3
    Explanation: t is "ece" which its length is 3.


 *  e c e b a  2 distinct
 *        i j
 * {
 * 
 *  b: 1
 * 
 * }
 * 
 * 
 * strategy:
 *  1) create a hashset to maintain a cache
 *  2) Set up 2 pointers, begin and end to keep track of the longest length, and which chars to remove from hashmap
 *  3) set up max variable to keep track of the max
 *  4) Traverse the string from 0 to end == length, while greedily keeping track of the max length
 *  5) return the maxLength
 * 
 */