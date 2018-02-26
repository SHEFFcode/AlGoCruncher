# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        funnel = [None for node in lists]
        merged_pointer = None
        head_nodes = [node for node in lists]
        next_list_id = [-1]  # we make it into array so we can pass it around by reference
        while True:
            if not funnel[0]:
                break
            if not merged_pointer:
                merged_pointer = funnel[0]
                funnel[0] = None
                self.populate_funnel(funnel, head_nodes, next_list_id)
            else:
                merged_pointer.next = funnel[0]
                funnel[0] = None
                self.populate_funnel(funnel, head_nodes, next_list_id)
        merged_pointer.next = None  # this terminates the new merged list
        return merged_pointer

    def populate_funnel(self, funnel, head_nodes, next_list_id):
        for index, value in enumerate(head_nodes):
            if next_list_id == -1:
                for i in range(len(head_nodes)):
                    pass

solution = Solution()
solution.mergeKLists([1, 2, 3])