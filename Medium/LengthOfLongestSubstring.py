class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        start = longest_string = 0
        hash_table = {}

        for i in range(len(s)):
            if s[i] in hash_table and start <= hash_table[s[i]]:
                start = hash_table[s[i]] + 1
            else:
                longest_string = max(longest_string, i - start + 1)

            hash_table[s[i]] = i

        return longest_string