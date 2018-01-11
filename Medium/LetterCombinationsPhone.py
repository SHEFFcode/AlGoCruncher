class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        digits_string = str(digits)
        digit_dictionary = dict()
        digit_dictionary.update({
            2: ['a', 'b', 'c'],
            3: ['d', 'e', 'f'],
            4: ['g', 'h', 'i'],
            5: ['j', 'k', 'l'],
            6: ['m', 'n', 'o'],
            7: ['p', 'q', 'r', 's'],
            8: ['t', 'u', 'v'],
            9: ['w', 'x', 'y', 'z']
        })
        digit_matrix = [[0] * len(digits_string)] * (3 ** len(digits_string))
        multiplier = 1
        divider = 1
        digit_pointer = 0
        letter_pointer = 0
        divider = 1
        number = 0
        for i in range(0, len(digit_matrix)):




            if i < 9:
                if i < 3:
                    if i < 1:
                        digit_matrix[i] = ['a', 'd', 'g']
                    if i < 2:
                        digit_matrix[i] = ['a', 'd', 'h']
                    if i < 3:
                        digit_matrix[i] = ['a', 'd', 'i']
                elif 3 <= i < 6:
                    if i < 4:
                        digit_matrix[i] = ['a', 'e', 'g']
                    if i < 5:
                        digit_matrix[i] = ['a', 'e', 'h']
                    if i < 6:
                        digit_matrix[i] = ['a', 'e', 'i']
                elif 6 <= i < 9:
                    if i < 7:
                        digit_matrix[i] = ['a', 'f', 'g']
                    if i < 8:
                        digit_matrix[i] = ['a', 'f', 'h']
                    if i < 9:
                        digit_matrix[i] = ['a', 'f', 'i']
            elif 9 <= i < 18:
                if i < 12:
                    digit_matrix[i] = ['b', 'd', '']
                elif 12 <= i < 15:
                    digit_matrix[i] = ['b', 'e', '']
                elif 15 <= i < 18:
                    digit_matrix[i] = ['b', 'f', '']
            elif 18 <= i < 27:
                if i < 21:
                    digit_matrix[i] = ['c', 'd', '']
                elif 21 <= i < 24:
                    digit_matrix[i] = ['c', 'e', '']
                elif 24 <= i < 27:
                    digit_matrix[i] = ['c', 'f', '']
        x = 0

# 000   |   100     |   200
# 001   |   101     |   201
# 002   |   102     |   202
# 010   |   110     |   210
# 011   |   111     |   211
# 012   |   112     |   212
# 020   |   120     |   220
# 021   |   121     |   221
# 022   |   122     |   222



solution = Solution()
solution.letterCombinations('234')