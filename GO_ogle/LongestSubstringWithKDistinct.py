class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        if not s:
            return 0
        if len(s) == 1:
            return 1
        letters_used = set()
        longest_string_length, current_string_length = 0, 0
        current_distinct, length, max_distinct = 0, len(s), k
        start_index_repeating_letter = 0
        last_letter_used = ''

        i = 0
        for j in range(1, length):
            if i == 0 and j == 1:  # initial run, we just want to make sure we get the first letter in there.
                letters_used.add(s[0])
                current_distinct += 1
                current_string_length += 1
                if len(s) > 1:
                    letters_used.add(s[1])
                    current_distinct += 1
                    current_string_length += 1
                    last_letter_used = s[1]
            elif current_distinct < max_distinct and s[j] not in letters_used:
                letters_used.add(s[j])
                last_letter_used = s[j]
                current_distinct += 1
                current_string_length += 1
            elif current_distinct <= max_distinct and s[j] in letters_used:
                current_string_length += 1
                if last_letter_used == s[j] and start_index_repeating_letter == 0:
                    start_index_repeating_letter = j - 1
                last_letter_used = s[j]
            elif current_distinct >= max_distinct and s[j] not in letters_used:
                if current_string_length > longest_string_length:
                    longest_string_length = current_string_length
                i = j - (k - 1)
                current_string_length = 0
                letters_used.clear()
                letters_used = set(s[i:j + 1])
                last_letter_used = s[j]
                current_distinct = len(letters_used)
                current_string_length += k if start_index_repeating_letter == 0 else j - start_index_repeating_letter + (k - 1)
                start_index_repeating_letter = 0

        return longest_string_length if longest_string_length > current_string_length else current_string_length

solution = Solution()
print(solution.lengthOfLongestSubstringKDistinct("a", 1))
# print(solution.lengthOfLongestSubstringKDistinct("ecebaaaajdhflhalrnjaerbasjjjjjjjjjjjjjlladsllllwliejejejslsrhladfzrhljgfbgafnlhagsdblkagfe", 2))


