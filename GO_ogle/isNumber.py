class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """
        try:
            possible_number = float(s) + 1 - 1
            return isinstance(possible_number, float)
        except ValueError:
            return False


solution = Solution()
print(solution.isNumber(""))
