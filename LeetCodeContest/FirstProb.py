class Solution(object):
    def kthGrammar(self, N, K):
        """
        :type N: int
        :type K: int
        :rtype: int
        """
        string_container = "0" if N > 0 else ""
        list_combos = ['01', '10', '0110', '1001']
        string_list = [0, 1]

        for i in range(1, N):
            opposite_list = []
            for item in string_list:
                opposite_list.append(1 - item)
            string_list += opposite_list
        for i in range(0, N):
            updated_string_container = ""
            for j in range(0, len(string_container)):
                if string_container[j] == '0':
                    updated_string_container += '01'
                elif string_container[j] == '1':
                    updated_string_container += '10'
            string_container = updated_string_container
        return int(string_container[K - 1])


solution = Solution()
print(solution.kthGrammar(3, 3))

