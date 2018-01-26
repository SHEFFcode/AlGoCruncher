class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        character_dictionary = {}
        lowest_index_char_in_dict, longest_substring = 0, 0
        for i, c in enumerate(s):
            character_dictionary[c] = i
            if len(character_dictionary) > k:
                lowest_index_char_in_dict = min(character_dictionary.values())
                del character_dictionary[s[lowest_index_char_in_dict]]
                lowest_index_char_in_dict += 1
            longest_substring = max(i - lowest_index_char_in_dict + 1, longest_substring)
        return longest_substring



solution = Solution()
# print(solution.lengthOfLongestSubstringKDistinct("a@b$5!a8alskj234jasdf*()@$&%&#FJAvjjdaurNNMa8ASDF-0321jf?>{}L:fh", 10))
# print(solution.lengthOfLongestSubstringKDistinct("aabcedbaba", 2))
print(solution.lengthOfLongestSubstringKDistinct("ecebaaaajdhflhalrnjaerbasjjjjjjjjjjjjjlladsllllwliejejejslsrhladfzrhljgfbgafnlhagsdblkagfe", 2))


