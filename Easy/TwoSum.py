class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dictionary = dict()
        for i in range(len(nums)):
            dictionary.update({nums[i]: i})
        for i in range(len(nums)):
            if target - nums[i] in dictionary and dictionary[target - nums[i]] != i:
                return [i, dictionary[target - nums[i]]]

solution = Solution()
print(solution.twoSum([3,2,4], 6))