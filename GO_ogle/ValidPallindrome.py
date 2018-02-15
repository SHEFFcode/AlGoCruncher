class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.lower()
        s = "".join(ch for ch in s if ch.isalnum())
        mid = len(s) / 2
        i, j = 0, len(s) - 1
        while i <= mid <= j:
            if s[i] == s[j]:
                i, j = i + 1, j - 1
                continue
            else:
                return False
        return True

solution = Solution()
print(solution.isPalindrome("A man, a plan, a anal: Panama"))
