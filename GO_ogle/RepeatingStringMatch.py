class Solution(object):
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """

        repetition_string = A
        subsequence_string = B
        number_of_repetitions = 1
        while subsequence_string not in repetition_string:
            repetition_string += A
            number_of_repetitions += 1
            if len(B) < len(repetition_string) and subsequence_string not in repetition_string and number_of_repetitions > len(B) % len(A):
                return -1
        return number_of_repetitions

solution = Solution()
print(solution.repeatedStringMatch("baa", "abaab"))