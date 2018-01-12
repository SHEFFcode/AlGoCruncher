class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) % 2 != 0:
            return False
        if len(s) == 0:
            return True
        symbol_dictionary = dict()
        symbol_dictionary.update({')': '(', '}': '{', ']': '['})
        match_stack = []

        for symbol in s:
            if symbol in symbol_dictionary and len(match_stack) == 0:
                return False
            if symbol in symbol_dictionary and symbol_dictionary[symbol] != match_stack[-1]:
                return False
            elif symbol in symbol_dictionary and symbol_dictionary[symbol] == match_stack[-1]:
                match_stack.pop()
            elif symbol not in symbol_dictionary:
                match_stack.append(symbol)
        return True if len(match_stack) == 0 else False

solution = Solution()
print(solution.isValid("([)]"))