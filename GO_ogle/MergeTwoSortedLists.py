# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        start_node = ListNode(0)
        tail_node = start_node
        while True:
            if not l1:
                if not start_node:
                    start_node = l2
                tail_node.next = l2
                break  # here we have finished with l1 list, and are just appending the l2 node.
            elif not l2:
                if not start_node:
                    start_node = l1
                tail_node.next = l1
                break  # here we have finished with the l2 list, and are just appending the l1 list
            elif l1.val <= l2.val:  # l1 val is smaller than l2, and should go on the end of our list
                if not start_node:
                    start_node = l1
                tail_node.next = l1
                l1 = l1.next  # move forward the l1 pointer
                tail_node = tail_node.next  # move forward the tail pointer
            elif l1.val > l2.val:
                if not start_node:
                    start_node = l2
                tail_node.next = l2
                l2 = l2.next  # move forward the l2 pointer
                tail_node = tail_node.next  # move forward the tail pointer
        return start_node.next
