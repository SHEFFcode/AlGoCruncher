class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length, maximum = 0, 0
        for item in nums:
            if item == 1:
                length += 1
            else:
                if length > maximum:
                    maximum = length
                length = 0
        if length > maximum:
            maximum = length
        return maximum

solution = Solution()
print(solution.findMaxConsecutiveOnes([]))