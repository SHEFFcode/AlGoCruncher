class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return nums
        for i in range(1, len(nums)):
            if nums[i - 1] == 0 and nums[i] != 0:
                j = i - 1
                while j > 0 and nums[j - 1] == 0:
                        j -= 1
                nums[j], nums[i] = nums[i], nums[j]
        return nums


solution = Solution()
print(solution.moveZeroes([0, 1, 0, 3, 12]))

