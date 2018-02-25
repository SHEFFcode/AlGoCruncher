# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head:
            return False
        fast_pointer, slow_pointer = head, head  # we will have a bit of a race between these pointers.
        while fast_pointer and slow_pointer and fast_pointer.next:  # basically while we are not at null (end of list)
            fast_pointer = fast_pointer.next.next  # fast pointer moves forward by 2
            slow_pointer = slow_pointer.next  # slow pointer moves forward by 1
            if slow_pointer == fast_pointer:  # slow and fast pointer point to the same node, we have a cycle
                return True  # say that we have a cycle
        return False  # if the conditions for the loop are not met, return false, we do not have a loop.

solution = Solution()
print(solution.hasCycle(ListNode(5)))
