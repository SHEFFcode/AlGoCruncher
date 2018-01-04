class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        length = len(s)
        if length == 1:
            return s
        container = [[0 for x in range(0, length)] for y in range(0, length)]
        for i in range(0, length):
            container[i][i] = 1
        for cl in range(2, length + 1):
            for i in range(0, length - cl + 1):
                j = i + cl - 1
                if s[i] == s[j] and cl == 2:
                    container[i][j] = 2
                elif s[i] == s[j]:
                    container[i][j] = container[i + 1][j - 1] + 2
                else:
                    container[i][j] = max(container[i][j - 1], container[i + 1][j])
        i, j, string, char_left = 0, length - 1, "", container[0][length - 1]
        for x in range(0, len(s) - 1):
            if container[i][j] > container[i + 1][j] and container[i][j] > container[i][j - 1]:
                string += s[j]
                char_left -= 1
                if container[i + 1][j] == 0 and container[i][j - 1] == 0 and container[i + 1][j - 1] == 0 and char_left > 0:
                    string += s[j - char_left:j][::-1]
                elif container[i + 1][j] == 1 and container[i][j - 1] == 1 and container[i + 1][j - 1] == 0 and char_left > 0:
                    string += s[j - char_left:j][::-1]
                i = i + 1
                j = j - 1

            elif container[i][j] > container[i + 1][j] and container[i][j] == container[i][j - 1]:
                i = i
                j = j - 1
            elif container[i][j] == container[i + 1][j] and container[i][j] > container[i][j - 1]:
                i = i + 1
                j = j
            elif container[i][j] == container[i + 1][j] and container[i][j] == container[i][j - 1]:
                i = i + 1
                j = j
        if string != string[::-1]:
            return string[0]
        return string


lcs = Solution()
print(lcs.longestPalindrome("abcda"))
