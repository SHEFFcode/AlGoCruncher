# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    longest = 0  # class variable to ensure we can update it anywhere in the recursion tree

    def longestUnivaluePath(self, root, inheritance=0):
        """
        :type root: TreeNode
        :rtype: int
        """
        # Recursive function that will do all of the work calculating longest path between like valued nodes
        def traverse(node):
            if not node:  # case where we have reached the end of the recursion tree and node.next is  None
                return 0
            left_len, right_len = traverse(node.left), traverse(node.right)  # this will give the len of each branch
            # We need this because we want to calculate the longest path treating each higher node as parent
            # This is the case where longest path is "hanging" off the current node, instead of extending from it
            left_len_w_current_node = left_len + 1 if node.left and node.left.val == node.val else 0
            right_len_w_current_node = right_len + 1 if node.right and node.right.val == node.val else 0
            self.longest = max(self.longest, left_len_w_current_node + right_len_w_current_node)
            # we return max of either right or left branch, because we can't include both branches in the parents
            # node calculation since these would not be "hanging" off the parent, but rather from the current node
            return max(left_len_w_current_node, right_len_w_current_node)
        traverse(root)  # just calling the traverse function with the root node
        return self.longest  # since we have been updating the self.longest val throughout we can return it now
