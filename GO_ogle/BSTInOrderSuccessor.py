# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderSuccessor(self, root, p):
        """
        :type root: TreeNode
        :type p: TreeNode
        :rtype: TreeNode
        """
        if not root or not p:
            return None
        if root is p:
            return root
        treasure_node = p.val
        current_closest = root
        self.traverse(root, treasure_node, current_closest)
        return current_closest

    def traverse(self, c_node, treasure_node, current_closest):
        if abs(c_node.val - treasure_node) < current_closest.val:
            current_closest = c_node
        if c_node.val == treasure_node + 1:
            return c_node
        if c_node.val == treasure_node:
            self.traverse(c_node.right, treasure_node, current_closest)  # have to go right because we are looking for a higher value then treasure
        elif c_node.val > treasure_node:
            self.traverse(c_node.left, treasure_node, current_closest)
        elif c_node.val < treasure_node:
            self.traverse(c_node.right, treasure_node, current_closest)
        return current_closest
