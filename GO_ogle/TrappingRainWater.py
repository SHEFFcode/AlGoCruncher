class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        height_stack = [0]
        accounted_for = []
        distance = [0]
        water_trapped = 0
        for i in range(0, len(height)):
            if height[i] < 1 and i == 0:
                continue
            elif height[i] < height_stack[-1]:
                distance[-1] += 1
            elif height[i] >= height_stack[-1] and height_stack[-1] != 0:
                water_trapped += (height_stack.pop() - accounted_for.pop()) * distance.pop()
                accounted_for[-1] += 1
                height_stack.append(height[i])
                accounted_for.append(0)
                distance.append(0)
            elif height[i] >= height_stack[-1] and height_stack[-1] == 0:
                continue
            elif height[i] < height_stack[:-1]:
                height_stack.append(height[i])
                accounted_for.append(0)
                distance.append(distance[:-1] + 1)
            elif height[i] > 0:
                height_stack.append(height[i])
                accounted_for.append(0)
                distance.append(1)
        return water_trapped

solution = Solution()
solution.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1])

