class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        string_representation = str(x)
        start = 0
        if string_representation[0] == "-":
            start = 1
        mid = len(string_representation) - start
        started = False
        j = len(string_representation) - 1

        for i in range(start, mid):
            while j == "0" and started is False:
                string_representation = string_representation[:j]
                j -= 1
            if j < i:
                if abs(int(string_representation)) > (2 ** 31 - 1):
                    return 0
                return int(string_representation)
            if i != j:
                string_list = list(string_representation)
                string_list[i], string_list[j] = string_list[j], string_list[i]
                string_representation = ''.join(string_list)
            j -= 1
            started = True
        if abs(int(string_representation)) > (2 ** 31 - 1):
            return 0
        return int(string_representation)

solution = Solution()
print(solution.reverse(1534236469))
