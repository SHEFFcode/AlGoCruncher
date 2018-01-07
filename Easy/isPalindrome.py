import math
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        multiplier = 10
        reversed_int = 0
        if x < 0:
            return False
        if x < 10:
            return True
        while math.floor(x / multiplier) >= 0:
            reversed_int = reversed_int * 10 + math.floor(math.floor((x % multiplier)) / multiplier * 10)
            if x == reversed_int:
                return True
            multiplier *= 10

        return x == reversed_int



        # reversed_int = 0
        # multiplier = 10.0
        # if x < 0:
        #     return False
        # if x < 10:
        #     return True
        # while math.floor(x / multiplier) > 0:
        #     reversed_int = reversed_int * 10 + \
        #                    math.floor((x - math.floor(x / multiplier) * multiplier) / (multiplier / 10))
        #     multiplier *= 10
        # reversed_int = reversed_int * 10 + math.floor(x / (multiplier / 10))
        # return x - reversed_int == 0.0


solution = Solution()
print(solution.isPalindrome(9999))
