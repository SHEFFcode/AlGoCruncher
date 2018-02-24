class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.append(0)
        n = len(nums)
        for i in range(len(nums)):  # delete those useless elements
            if nums[i] < 0 or nums[i] >= n:
                nums[i] = 0
        for i in range(len(nums)):  # use the index as the hash to record the frequency of each number
            nums[nums[i] % n] += n
        for i in range(1, len(nums)):
            if nums[i] / n == 0:
                return i
        return n

        # minimum, maximum = 0, 0
        # needed = None
        # lead_pointer, follow_pointer = 1, 0
        # while lead_pointer < len(nums):
        #     if nums[follow_pointer] == 0 and minimum == 0 and maximum == 0:
        #         follow_pointer, lead_pointer = follow_pointer + 1, lead_pointer + 1
        #         continue
        #     elif nums[lead_pointer] == 0 and minimum == 0 and maximum == 0:
        #         lead_pointer += 1
        #     if nums[follow_pointer] == 0:
        #         follow_pointer += 1
        #     if nums[lead_pointer] > nums[follow_pointer] and minimum == 0 and maximum == 0:
        #         minimum, maximum = nums[follow_pointer], nums[lead_pointer]
        #     elif minimum == 0 and maximum == 0:
        #         minimum, maximum = nums[lead_pointer], nums[follow_pointer]
        #     if nums[lead_pointer] < 1:
        #         lead_pointer += 1
        #         continue
        #     if abs(nums[lead_pointer] - nums[follow_pointer]) > 1 and needed is None:
        #         needed = min(nums[lead_pointer], nums[follow_pointer]) + 1
        #         if needed == maximum:
        #             needed = maximum + 1
        #         elif needed == minimum:
        #             needed = minimum - 1
        #     if nums[lead_pointer] == needed:
        #         needed = None
        #     if nums[lead_pointer] < minimum:
        #         minimum = nums[lead_pointer]
        #     elif nums[lead_pointer] > maximum:
        #         maximum = nums[lead_pointer]
        #     lead_pointer, follow_pointer = lead_pointer + 1, follow_pointer + 1
        # if minimum > 1:
        #     needed = minimum - 1
        # return needed if needed else maximum + 1

solution = Solution()
print(solution.firstMissingPositive([3, 4, -1, 1]))

# I think the key idea here is to get the pointers to remember where difference is more then 1, and then if it happens
# again, u see if the start of the itnerval is smaller or bigger, if smaller then that interval becomes the missing
# interval. Just keep filling in the missing interval until ur done with it.
