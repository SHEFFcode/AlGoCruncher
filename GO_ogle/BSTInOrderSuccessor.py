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
        if p.right:  # the node has a right child, which would contain the in order successor
            return self.find_min(p.right)

        successor = None
        while root:
            if root.val > p.val:  # possible successor
                successor = root
                root = root.left
            elif root.val < p.val:  # successor is on the right
                root = root.right
            else:  # we ran into the p node while traversing, so successor is its parent node
                break
        return successor

    def find_min(self, node):
        min_node = node
        while min_node.left:  # find the min of the right child of the p node
            min_node = min_node.left
        return min_node

