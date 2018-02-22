class Solution(object):
    def shortestPalindrome(self, s):
        full_reversed_string = s + "*" + s[::-1]
        kmp_container = [0]
        for i in range(1, len(full_reversed_string)):
            index = kmp_container[i - 1]
            while index > 0 and full_reversed_string[index] != full_reversed_string[i]:
                index = kmp_container[index - 1]
            kmp_container.append(index + 1 if full_reversed_string[index] == full_reversed_string[i] else 0)
        return s[kmp_container[-1]:][::-1] + s


solution = Solution()
print(solution.shortestPalindrome('aacecaaa'))
