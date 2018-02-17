class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        post_reset_vals, pre_reset_vals, maximum = 0, 0, 0
        for digit in nums:
            if digit == 1:
                pre_reset_vals += 1
            elif post_reset_vals == 0:
                post_reset_vals += 1
            else:
                c_max = pre_reset_vals + post_reset_vals
                if c_max > maximum:
                    maximum = c_max
                pre_reset_vals = post_reset_vals - 1
                post_reset_vals = 0
        if (pre_reset_vals + post_reset_vals) > maximum:
            maximum = pre_reset_vals + post_reset_vals
        return maximum

solution = Solution()
print(solution.findMaxConsecutiveOnes([1,0,1,1,0]))