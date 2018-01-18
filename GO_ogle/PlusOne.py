class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        if not digits:
            return []
        integer = int("".join(str(x) for x in digits))
        return [int(d) for d in str(integer + 1)]

solution = Solution()
print(solution.plusOne([1, 2]))