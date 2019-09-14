class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // let's initialize the anagram list
        List<Integer> anagramIndex = new ArrayList<>();

        // now let's go from 0 to length of string less length of pattern + 1, which is running off the array
        for(int i = 0; i < s.length() - p.length() + 1; i++){
            // first, let's grab the substring of length p.length()
            String currentWindow = s.substring(i, p.length() + i);

            // then let's use a helper function that will find whether a window is an anagram in O(m time)
            if(isAnagram(currentWindow, p)){
                anagramIndex.add(i);
            }
        }

        // let's make sure to return the list as requested
        return anagramIndex;
    }
    
    boolean isAnagram(String window, String pattern) {
        // if the two strings are not same length, they are not anagrams
        if(window.length() != pattern.length()){
            return false;
        }
        
        // there are only so many letters in lowercase english alphabet
        int[] chars = new int[26];

        // let's populate the array with chars
        for(int i = 0; i < window.length(); i++){
            chars[window.charAt(i)-'a']++;
            chars[pattern.charAt(i)-'a']--;
        }
        
        // let's see if any of the items in the array are orphaned
        for(int i = 0; i < 26; i++) {
            if(chars[i] != 0){
                return false;
            }
        }
        
        return true;
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