class Solution(object):
    def kEmptySlots(self, flowers, k):
        """
        :type flowers: List[int]
        :type k: int
        :rtype: int
        """
        if len(flowers) < 2:
            return -1
        flower_dict = dict()
        for i in range(0, len(flowers)):
            flower_dict[flowers[i]] = i
        for j in range(0, len(flowers)):
            if flowers[j] - k in flower_dict:
                for l in range(flowers[j] - k, flowers[j] + 1):
                    if l in flower_dict and flower_dict[l] < flower_dict[flowers[j - k]] and flowers[j] - flowers[j - k - 1] != 1:
                        return -1
                if (flowers[j]) - flowers[j] - k != 1:
                    return flower_dict[flowers[j] - k]
            elif flowers[j] + k in flower_dict:
                for l in range(flowers[j] + 1, flowers[j] + k + 1):
                    if l in flower_dict and flower_dict[flowers[j] + k] < flower_dict[l]:
                        return -1
                if flowers[j + k] - (flowers[j]) != 1:
                    return flower_dict[flowers[j] + k]
        return -1

solution = Solution()
print(solution.kEmptySlots([6,5,8,9,7,1,10,2,3,4], 2))
