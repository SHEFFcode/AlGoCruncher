# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if not head:
            return None
        pointer = head
        while pointer:  # create a list of new nodes between the old nodes
            next_ref = pointer.next
            pointer.next = RandomListNode(pointer.label)
            pointer.next.next = next_ref
            pointer = next_ref
        pointer = head  # go back to the front
        while pointer:  # adjust the random pointers
            pointer.next.random = pointer.random.next if pointer.random else pointer.random
            pointer = pointer.next.next if pointer.next else pointer.next
        original = head
        copy = head.next
        deep_head = head.next  # start of the deeply copied linked list
        while original and copy:
            original.next = original.next.next if original.next else original.next
            copy.next = copy.next.next if copy.next else copy.next
            original = original.next
            copy = copy.next
        return deep_head
