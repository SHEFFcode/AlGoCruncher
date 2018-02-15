class Solution(object):
    def isOneEditDistance(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if not s and not t:
            return False
        s_length, t_length = len(s), len(t)
        if abs(s_length - t_length) > 1:
            return False
        i, j, number_of_edits = 0, 0, 0
        while i < s_length and j < t_length:
            if s[i] == t[j]:
                i, j = i + 1, j + 1
            else:
                number_of_edits += 1
                if number_of_edits > 1:
                    return False
                if s_length > t_length:
                    i += 1
                elif t_length > s_length:
                    j += 1
                else:
                    i, j = i + 1, j + 1
        if i < s_length or j < t_length:
            number_of_edits += 1
        return number_of_edits == 1

solution = Solution()
print(solution.isOneEditDistance("a", ""))
