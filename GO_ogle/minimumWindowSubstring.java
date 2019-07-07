package com.company;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        // if (!inputIsValid(s, t)) {
        // return ""; // per question ask
        // }

        // Step 1: declare the needed variables
        int liw = 0;
        int minW = s.length(); // let's start here as a reasonable max.
        int length = t.length();
        int[] indexes = { 0, 0 };
        int start = 0;

        // Step 2: Get the char[]s
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Step 3, build the map
        Map<Character, Integer> tMap = buildTMap(tArray);

        // Step 4: Iterate through sArr to populate our answer.
        for (int end = 0; end < sArray.length; end++) {
            char c = sArray[end];
            if (tMap.containsKey(c)) {
                tMap.merge(c, -1, Integer::sum); // this will update the map
                int count = tMap.get(c);
                if (count == 0) {
                    liw++;
                }
                if (liw == length) {
                    int windowLength = end - start + 1; // take care of the off by 1 error.
                    if (windowLength < minW) {
                        minW = windowLength;
                        indexes[0] = start;
                        indexes[1] = end;
                    }
                    for (; start < end; start++) { // will only go up until end
                        c = sArray[start];
                        if (tMap.containsKey(c)) {
                            tMap.merge(c, 1, Integer::sum);
                            count = tMap.get(c);
                            if (count > 0) {
                                liw--;
                            }
                            if (liw != length) {
                                windowLength = end - start + 1;
                                if (windowLength < minW) {
                                    minW = windowLength;
                                    indexes[0] = start;
                                    indexes[1] = end;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Step 4: return the substring as requested by the problem.
        return s.substring(indexes[0], indexes[1] + 1);

    }

    private Map<Character, Integer> buildTMap(char[] tArr) {
        Map<Character, Integer> tMap = new HashMap<>(tArr.length); // let's give it a sensible default size.
        for (char c : tArr) {
            tMap.merge(c, 1, Integer::sum); // this will add 1 if there is already a value in there.
        }

        return tMap;
    }

    private boolean inputIsValid(String s, String t) {
        throw new UnsupportedOperationException(); // TODO: Implement this method.
    }
}