# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        stringNumberOne = ''
        stringNumberTwo = ''

        current_node = l1

        while current_node is not None:
            stringNumberOne += str(current_node.val)
            current_node = current_node.next
        current_node = l2
        while current_node is not None:
            stringNumberTwo += str(current_node.val)
            current_node = current_node.next

        numberOne = int(stringNumberOne[::-1])
        numberTwo = int(stringNumberTwo[::-1])
        sumOfNumbers = numberOne + numberTwo
        stringSum = str(sumOfNumbers)[::-1]
        outputList = ListNode(stringSum[0])

        current_node = outputList

        for i in range(1, len(stringSum)):
            current_node.next = ListNode(stringSum[i])
            current_node = current_node.next

        return outputList