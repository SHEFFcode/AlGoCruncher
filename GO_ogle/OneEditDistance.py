class Solution(object):
    def isOneEditDistance(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) > len(t):
            first_string, second_string = s, t
        else:
            first_string, second_string = t, s

        number_of_edits, column_edits = 0, 0
        if (len(first_string) == len(second_string) and first_string == second_string) or abs(len(first_string)
                                                                                              - len(second_string)) > 1:
            return False

        diff_matrix = [[0 for _ in range(len(second_string))] for _ in range(len(first_string))]

        for i in range(len(first_string)):
            row_sum = 0
            for j in range(len(second_string)):
                if first_string[i] == second_string[j]:
                    diff_matrix[i][j] = 1
                    row_sum += 1
            if row_sum == 0:
                number_of_edits += 1
        for k in range(len(second_string)):
            column_sum = 0
            for l in range(len(first_string)):
                if diff_matrix[l][k] == 1:
                    column_sum += 1
            if column_sum == 0:
                column_edits += 1
                number_of_edits = max(number_of_edits, column_edits)
        return number_of_edits == 1

solution = Solution()
print(solution.isOneEditDistance("geek", "geeks"))
