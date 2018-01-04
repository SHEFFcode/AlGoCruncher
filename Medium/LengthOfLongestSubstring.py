class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        if length == 1:
            return s
        container = [[0 for x in range(0, length)] for y in range(0, length)]
        for i in range(0, length):
            for j in range(0, length):
                if i == j:
                    container[i][j] = 1
                elif s[i] == s[j]:
                    container[i][j] = 1
        longest_string = ''
        for i in range(0, length):
            longest_string_list = []
            started = False
            current_longest_string = ''

            for j in range(0, length):

                if container[i][j] == 1:
                    if started is False:
                        current_longest_string += s[j]
                        started = True
                    elif started is True:
                        longest_string_list.append(current_longest_string)
                        current_longest_string = ''
                        started = False
                elif container[i][j] == 0 and started is True:
                    current_longest_string += s[j]

            for string in longest_string_list:
                if len(string) > len(longest_string):
                    longest_string = string


        return longest_string


solution = Solution()
print(solution.lengthOfLongestSubstring("pwwkew"))