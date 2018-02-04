class Solution(object):
    def addBoldTag(self, s, dict):
        """
        :type s: str
        :type dict: List[str]
        :rtype: str
        """
        length = len(s)
        border_markers = [0 for i in range(length + 1)]
        for string in dict:
            i = -1
            try:
                i = s.index(string, i + 1)
            except ValueError:
                i = i
            while i >= 0:
                border_markers[i] += 1  # border opens
                border_markers[i + len(string)] -= 1  # border closes
                try:
                    i = s.index(string, i + 1)
                except ValueError:
                    break
        bolded_string = ""
        border_indicator = 0
        for i in range(0, length + 1):
            current_char_border_indicator = border_indicator + border_markers[i]
            if current_char_border_indicator > 0 and border_indicator == 0:  # current char is start of border
                bolded_string += "<b>"
            if current_char_border_indicator == 0 and border_indicator > 0:  # current char is end of border
                bolded_string += "</b>"
            if i == length:  # we've reached the end of the string, we end
                break
            bolded_string += s[i]  # we add the current character either way
            border_indicator = current_char_border_indicator  # we update overall border indicator to current one
        return bolded_string

solution = Solution()
print(solution.addBoldTag("aaabbcc", ["a", "c"]))