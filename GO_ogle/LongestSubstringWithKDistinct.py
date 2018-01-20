class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        if not s:
            return 0
        letters_used = []
        longest_string_length, current_string_length = 0, 0
        current_distinct, length, max_distinct = 0, len(s), k

        i = 0
        for j in range(1, length):
            if i == 0 and j == 1:  # initial run, we just want to make sure we get the first letter in there.
                letters_used.append(s[0])
                current_distinct += 1
                current_string_length += 1
            elif current_distinct < max_distinct and s[j] not in letters_used:
                letters_used.append(s[j])
                current_distinct += 1
                current_string_length += 1
            elif current_distinct <= max_distinct and s[j] in letters_used:
                current_string_length += 1
            elif current_distinct >= max_distinct and s[j] not in letters_used:
                if current_string_length > longest_string_length:
                    longest_string_length = current_string_length
                i = j - 1
                current_string_length = 0
                del letters_used[:]
                letters_used.append(s[i])
                letters_used.append(s[j])
                current_distinct = 2
                current_string_length += 2

        return longest_string_length if longest_string_length > current_string_length else current_string_length

solution = Solution()
print(solution.lengthOfLongestSubstringKDistinct("ecebaaaajdhflhalrnjaerbasjjjjjjjjjjjjjlladsllllwliejejejslsrhladfzrhljgfbgafnlhagsdblkagfe", 2))


