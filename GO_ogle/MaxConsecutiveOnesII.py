class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return None
        max_1s, current_1s = 0, 0
        flip_index = None
        for index, digit in enumerate(nums):
            if digit == 1:
                current_1s += 1
            elif digit == 0 and flip_index is None:
                flip_index = index
                current_1s += 1  # this is the first time we run into a 0, so we just flip it
            elif digit == 0 and flip_index is not None:
                if current_1s > max_1s:
                    max_1s = current_1s
                current_1s = index - flip_index
                flip_index = index
        if current_1s > max_1s:
            max_1s = current_1s
        return max_1s


solution = Solution()
print(solution.findMaxConsecutiveOnes([1, 0, 1, 1, 0, 1, 1, 1, 0, 1]))
