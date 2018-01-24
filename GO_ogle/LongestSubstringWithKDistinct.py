class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        if k == 0 or not s:
            return 0
        string_length = len(s)
        unique_set = set(s)
        if unique_set < k:
            return 0
        window_start = 0
        window_end = 0
        max_window_size = 1

        unique_set.clear()
        unique_set.add(s[0])
        current_string = s[0]

        for i in xrange(1, string_length):
            unique_set.add(s[i])
            window_end += 1
            current_string += s[i]

            set_length = len(set(current_string))

            while set_length > k:
                current_string = current_string[1:]
                set_length = len(set(current_string))
                window_start += 1

            if window_end - window_start + 1 > max_window_size:
                max_window_size = window_end - window_start + 1
        return max_window_size



solution = Solution()
# print(solution.lengthOfLongestSubstringKDistinct("eceba", 2))
print(solution.lengthOfLongestSubstringKDistinct("ecebaaaajdhflhalrnjaerbasjjjjjjjjjjjjjlladsllllwliejejejslsrhladfzrhljgfbgafnlhagsdblkagfe", 2))


