class Solution(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        string_container = input.split('\n')
        longest_string = ""
        current_string = string_container[0]
        t_count = 0
        pointer = 1
        current_dir = [string_container[0]]
        for i in range(1, len(string_container)):
            if string_container[i].count('\t') > t_count:
                t_count = string_container[i].count('\t')
                current_string = current_string + '/' + string_container[i][t_count:]
                pointer += 1
                if '.' in string_container[i] and len(current_string) > len(longest_string):
                    longest_string = current_string
                else:
                    current_dir.append('' + string_container[i][t_count:])
            elif string_container[i].count('\t') <= t_count:
                t_count = string_container[i].count('\t')
                t_level = string_container[i].count('\t')
                current_dir = current_dir[0:t_level]
                pointer -= string_container[i].count('\t')
                if t_count == t_level and '.' in string_container[i]:
                    current_string = '/'.join(current_dir) + '/' + string_container[i][t_count:]
                    if len(current_string) > len(longest_string):
                        longest_string = current_string
                        current_string = '/'.join(current_dir)
                else:
                    current_string = '/'.join(current_dir) + '/' + string_container[i][t_count:]
                    current_dir.append('' + string_container[i][t_count:])
        if len(current_string) > len(longest_string) and '.' in current_string:
            if current_string[0:1] == '/':
                current_string = current_string[1:]
            return len(current_string)
        if longest_string[0:1] == '/':
            longest_string = longest_string[1:]
        return len(longest_string)
solution = Solution()
print(solution.lengthLongestPath("skd\n\talskjv\n\t\tlskjf\n\t\t\tklsj.slkj\n\t\tsdlfkj.sdlkjf\n\t\tslkdjf.sdfkj\n\tsldkjf\n\t\tlskdjf\n\t\t\tslkdjf.sldkjf\n\t\t\tslkjf\n\t\t\tsfdklj\n\t\t\tlskjdflk.sdkflj\n\t\t\tsdlkjfl\n\t\t\t\tlskdjf\n\t\t\t\t\tlskdjf.sdlkfj\n\t\t\t\t\tlsdkjf\n\t\t\t\t\t\tsldkfjl.sdlfkj\n\t\t\t\tsldfjlkjd\n\t\t\tsdlfjlk\n\t\t\tlsdkjf\n\t\tlsdkjfl\n\tskdjfl\n\t\tsladkfjlj\n\t\tlskjdflkjsdlfjsldjfljslkjlkjslkjslfjlskjgldfjlkfdjbljdbkjdlkjkasljfklasjdfkljaklwejrkljewkljfslkjflksjfvsafjlgjfljgklsdf.a"))