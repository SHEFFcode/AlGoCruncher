class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        current_string = ''
        longest_pallindrome = ''

        if len(s) == 1:
            return s

        for char in s:
            if not longest_pallindrome:
                longest_pallindrome = char
            if current_string + char == (current_string + char)[::-1] and len(current_string + char) > len(longest_pallindrome):
                longest_pallindrome = current_string + char
            current_string += char

        if longest_pallindrome and longest_pallindrome == s[-len(longest_pallindrome)] and longest_pallindrome == s[len(longest_pallindrome) - 1 + 1]:
            reverse_string = s[len(longest_pallindrome):][::-1] + s[len(longest_pallindrome):]
        else:
            reverse_string = s[len(longest_pallindrome):][::-1] + s
        return reverse_string

solution = Solution()
print(solution.shortestPalindrome("adcba"))

