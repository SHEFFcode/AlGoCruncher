class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        minimum, max = 0, 0
        needed = None
        lead_pointer, follow_pointer = 0, 1
        for _ in range(1, len(nums)):
            if nums[lead_pointer] > nums[follow_pointer] and minimum == 0 and max == 0:
                minimum, max = nums[follow_pointer], nums[lead_pointer]
            elif minimum == 0 and max == 0:
                minimum, max = nums[lead_pointer], nums[follow_pointer]
            if abs(nums[lead_pointer] - nums[follow_pointer]) > 1:
                needed = min(nums[lead_pointer], nums[follow_pointer]) + 1
            if nums[lead_pointer] == needed:
                needed = None
            lead_pointer, follow_pointer = lead_pointer + 1, follow_pointer + 1
        if minimum > 1:
            needed = minimum - 1
        return needed if needed else max + 1

solution = Solution()
print(solution.firstMissingPositive([3, 4, -1, 1]))
