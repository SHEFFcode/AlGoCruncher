class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) % 2 != 0:
            return False
        matching_pair = {')': '(', ']': '[', '}': '{'}
        stack = []

        for char in s:
            if char not in matching_pair:
                stack.append(char)
            else:
                if stack and matching_pair[char] == stack.pop():
                    continue
                else:
                    return False
        return True if not stack else False

solution = Solution()
print(solution.isValid("(("))
