# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type headA, headB: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None
        a_pointer, b_pointer = headA, headB
        a_list_len, b_list_len = 0, 0
        while a_pointer.next is not None:
            a_pointer = a_pointer.next
            a_list_len += 1
        while b_pointer.next is not None:
            b_pointer = b_pointer.next
            b_list_len += 1
        if a_pointer is b_pointer:  # we have a merge
            diff = abs(a_list_len - b_list_len)
            counter = 0
            a_pointer, b_pointer = headA, headB
            while counter < diff:
                if a_list_len > b_list_len:
                    a_pointer = a_pointer.next
                    counter += 1
                else:
                    b_pointer = b_pointer.next
                    counter += 1
            while a_pointer is not b_pointer:
                a_pointer, b_pointer = a_pointer.next, b_pointer.next
            return a_pointer
        return None

