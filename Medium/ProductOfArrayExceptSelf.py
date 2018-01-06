class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        length = len(nums)
        multiplied_array = [0] * length
        prior_sum = 1
        odd_array = False
        mid_point = 0
        for i in range(0, length):
            if i == length - 1:
                return multiplied_array
            j = length - i - 1
            if i < j and i == 0:
                multiplied_array[i], multiplied_array[j] = nums[j], nums[i]
            elif i < j:
                multiplied_array[i] = multiplied_array[i - 1] * nums[j] * nums[i - 1]
                multiplied_array[j] = multiplied_array[j + 1] * nums[i] * nums[j + 1]
            elif i > j:
                if odd_array is True:
                    multiplied_array[mid_point] *= nums[i + 1] * nums[j - 1]
                multiplied_array[i + 1] = multiplied_array[i + 1] * nums[i] * nums[j] * prior_sum
                multiplied_array[j - 1] = multiplied_array[j - 1] * nums[i] * nums[j] * prior_sum
                prior_sum *= nums[i] * nums[j]
            elif i == j:
                prior_sum *= nums[i]
                multiplied_array[i] = nums[i + 1] * nums[i - 1]
                multiplied_array[i + 1] *= nums[i]
                multiplied_array[j - 1] *= nums[i]
                odd_array = True
                mid_point = i
        return multiplied_array

solution = Solution()
print(solution.productExceptSelf([1,2,3,4,5,6,7]))