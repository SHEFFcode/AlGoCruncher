class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return -1
        earliest = 0
        letter_hash = dict()
        earliest_set = False
        for index, letter in enumerate(s):
            if letter in letter_hash:
                index_arr = letter_hash[letter]
                index_arr[1] = index_arr[1] + 1
                letter_hash[letter] = index_arr
            else:
                letter_hash[letter] = [index, 1]
        for key in letter_hash:
            if letter_hash[key][1] == 1 and (letter_hash[key][0] < earliest or not earliest_set):
                earliest = letter_hash[key][0]
                if not earliest_set:
                    earliest_set = True
            else:
                continue
        return earliest if earliest_set else -1


solution = Solution()
print(solution.firstUniqChar("loveleetcode"))
