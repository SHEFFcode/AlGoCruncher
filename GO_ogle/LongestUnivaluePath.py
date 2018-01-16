# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    longest = 0
    current_longest = 0
    value_to_match = None

    def longestUnivaluePath(self, root, inheritance=0):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return self.current_longest
        if root.left is None and root.right is None:
            return self.current_longest
        current_node = root
        current_value = root.val
        if self.value_to_match is None:
            self.value_to_match = current_value
        right_child_value = current_node.right.val if current_node.right is not None else False
        left_child_value = current_node.left.val if current_node.left is not None else False
        if (right_child_value and left_child_value and self.value_to_match != right_child_value
                and self.value_to_match != left_child_value):
            self.current_longest = 0
            inheritance = 0
            print("pvalue: {0}, rvalue: {1}, lvalue:{2}".format(self.value_to_match, right_child_value, left_child_value))
            print("Neither matched, {0}".format(self.current_longest))
            self.value_to_match = current_node.left.val
            self.longestUnivaluePath(current_node.left, inheritance)
            self.current_longest = 0
            self.value_to_match = current_node.right.val
            self.longestUnivaluePath(current_node.right, inheritance)
        elif (left_child_value and right_child_value and self.value_to_match == left_child_value
              and self.value_to_match == right_child_value):
            self.value_to_match = current_value
            self.current_longest += 2
            print("pvalue: {0}, rvalue: {1}, lvalue:{2}".format(self.value_to_match, right_child_value, left_child_value))
            print("Both matched, {0}".format(self.current_longest))
            if self.current_longest > self.longest:
                self.longest = self.current_longest
            inheritance += 1
            self.longestUnivaluePath(current_node.left, inheritance)
            self.longestUnivaluePath(current_node.right, inheritance)
        elif left_child_value and self.value_to_match == left_child_value:
            self.current_longest += 1
            self.value_to_match = current_value
            print("pvalue: {0}, rvalue: {1}, lvalue:{2}".format(self.value_to_match, right_child_value, left_child_value))
            print("left matched, {0}".format(self.current_longest))
            if self.current_longest > self.longest:
                self.longest = self.current_longest
            self.longestUnivaluePath(current_node.left)
        elif right_child_value and self.value_to_match == right_child_value:
            self.current_longest += 1
            self.value_to_match = current_value
            print("pvalue: {0}, rvalue: {1}, lvalue:{2}".format(self.value_to_match, right_child_value, left_child_value))
            print("Right matched, {0}".format(self.current_longest))
            if self.current_longest > self.longest:
                self.longest = self.current_longest
            self.longestUnivaluePath(current_node.right)
        return self.longest
