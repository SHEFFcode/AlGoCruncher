class Solution(object):
    cache = {}

    def calculate_runs(self, number_of_runs):  # :rtype: int number of ways to score that many runs
        if number_of_runs < 0:
            return 0
        elif number_of_runs == 0:
            return 1
        elif 0 < number_of_runs < 4:
            return number_of_runs
        else:
            self.cache[number_of_runs] = self.calculate_runs(number_of_runs - 1) \
                                         + self.calculate_runs(number_of_runs - 2) \
                                         + self.calculate_runs(number_of_runs - 4)
            return self.cache[number_of_runs]

solution = Solution()
print(solution.calculate_runs(25))