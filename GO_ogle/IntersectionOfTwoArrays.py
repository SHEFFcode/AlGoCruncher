class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1, nums2 = set(nums1), set(nums2)
        short_set, long_set = (nums1, nums2) if len(nums1) < len(nums2) else (nums2, nums1)
        intersect_list = list()
        for short_item in short_set:
            for long_item in long_set:
                if short_item == long_item:
                    intersect_list.append(short_item)
        return intersect_list

solution = Solution()
print(solution.intersection([1, 2, 3, 9], [4, 5, 6, 3]))
