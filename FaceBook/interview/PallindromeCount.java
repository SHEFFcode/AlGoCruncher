import java.util.*;

class PallindromeCount {
    public static void main(String[] input) {
        Solution sol = new Solution();
        int count = sol.pallindromeCount("aabbccd");
        System.out.println(count);
    }

    static class Solution {
        public int pallindromeCount(String input) {
            int palCount = 0;
            Set<String> foundPallindromes = new HashSet<>();
            char[] inputArr = input.toCharArray();

            for (int i = 0; i < input.length(); i++) {
                // Grow left
                int start = i - 1;
                int end = i;
                while (start >= 0 && end < inputArr.length && inputArr[start] == inputArr[end]) {
                    if (!foundPallindromes.contains(input.substring(start, end + 1))) {
                        palCount++;
                        foundPallindromes.add(input.substring(start, end + 1));
                    }
                    start--;
                }
                // Grow right
                start = i;
                end = i + 1;
                while (start >= 0 && end < inputArr.length && inputArr[start] == inputArr[end]) {
                    if (!foundPallindromes.contains(input.substring(start, end + 1))) {
                        palCount++;
                        foundPallindromes.add(input.substring(start, end + 1));
                    }
                    end++;
                }
                // Grow both
                start = i - 1;
                end = i + 1;
                while (start >= 0 && end < inputArr.length && inputArr[start] == inputArr[end]) {
                    if (!foundPallindromes.contains(input.substring(start, end + 1))) {
                        palCount++;
                        foundPallindromes.add(input.substring(start, end + 1));
                    }
                    end++;
                    start--;
                }
            }

            foundPallindromes.forEach(System.out::println);

            return palCount;
        }
    }
}

/**
 * a a b b c c d
 * i
 */