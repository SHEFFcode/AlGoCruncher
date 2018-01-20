class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        length = len(height)
        if length < 1:
            return 0
        max_height_left = [0 for x in range(0, length)]  # list will contain max height to the left of current item
        max_height_right = [0 for x in range(0, length)]  # list will contain max height to the right of the citem
        water_trapped = 0
        max_height_left[0] = height[0]  # we know this is true, because there are no elements to the left
        for i in range(1, length):  # fill up the left array from el 1 to the end
            max_height_left[i] = max(max_height_left[i - 1], height[i])  # we want the highest to left from cpoint
        max_height_right[length - 1] = height[length - 1]  # we know this is true because there are no el to the right
        for i in range(length - 2, -1, -1):  # fill up the right array from len - 1 to start
            max_height_right[i] = max(max_height_right[i + 1], height[i])  # we want the highest to the right from cpoint
        # we now calculate the water based on whether celement is lower then highest to left and right
        for i in range(0, length):
            water_trapped += min(max_height_right[i], max_height_left[i]) - height[i]
        return water_trapped

solution = Solution()
print(solution.trap([]))

