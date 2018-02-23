class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        minimum, maximum = 0, 0
        needed = None
        lead_pointer, follow_pointer = 1, 0
        while lead_pointer < len(nums):
            if nums[follow_pointer] == 0:
                follow_pointer, lead_pointer = follow_pointer + 1, lead_pointer + 1
                continue
            elif nums[lead_pointer] == 0:
                lead_pointer += 1
            if nums[lead_pointer] > nums[follow_pointer] and minimum == 0 and maximum == 0:
                minimum, maximum = nums[follow_pointer], nums[lead_pointer]
            elif minimum == 0 and maximum == 0:
                minimum, maximum = nums[lead_pointer], nums[follow_pointer]
            if nums[lead_pointer] < 1:
                lead_pointer += 1
                continue
            if abs(nums[lead_pointer] - nums[follow_pointer]) > 1:
                needed = min(nums[lead_pointer], nums[follow_pointer]) + 1
            if nums[lead_pointer] == needed:
                needed = None
            if nums[lead_pointer] < minimum:
                minimum = nums[lead_pointer]
            elif nums[lead_pointer] > maximum:
                maximum = nums[lead_pointer]
            lead_pointer, follow_pointer = lead_pointer + 1, follow_pointer + 1
        if minimum > 1:
            needed = minimum - 1
        return needed if needed else maximum + 1

solution = Solution()
print(solution.firstMissingPositive([2,0,3,4,10]))
