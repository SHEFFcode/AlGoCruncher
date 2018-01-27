class Solution(object):
    def bold_it_up(self, s, print_dictionary):
        output_string = ''
        words_used = ''
        for i in range(0, len(s)):
            if i in print_dictionary:
                output_string = output_string + '<b>' + print_dictionary[i] + '</b>'
                words_used += print_dictionary[i]
            elif i not in print_dictionary and i > len(words_used) - 1:
                output_string += s[i]
                words_used += s[i]
        return output_string

    def addBoldTag(self, s, dict):
        """
        :type s: str
        :type dict: List[str]
        :rtype: str
        """
        start, end = 0, 0
        string_list, single_string = [], ''
        print_dictionary = {}
        for i in range(0, len(s)):
            if i in dict:
                single_string += s[i]
                print_dictionary[i] = i
                continue
            for j in range(i + 1, len(s) + 1):
                if s[i:j] in dict:
                    if i <= end + 1:
                        single_string += s[start:j]
                        end = end + j
                        start = i
                    else:
                        string_list.append(single_string)
                        print_dictionary[start] = single_string
                        start = i
                        single_string = s[start:j]
        if len(single_string) > 0:
            print_dictionary[start] = single_string
        bolded_string = self.bold_it_up(s, print_dictionary)
        return bolded_string



solution = Solution()
print(solution.addBoldTag("abcxyz123", ["abc","123"]))

