class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        i, j = 1, 0
        length = len(nums)
        while i < len(nums):  # we want to keep track of the original length. Also the engine will optimize this call
            if nums[i] == nums[j]:
                length -= 1
            else:
                j += 1
                nums[j], nums[i] = nums[i], nums[j]
            i += 1
        return length


solution = Solution()
print(solution.removeDuplicates([1,1,2]))
