# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.max = 1
        self.find_diameter(root)
        return self.max - 1

    def find_diameter(self, root):
        if not root:
            return 0
        left = self.find_diameter(root.left)
        right = self.find_diameter(root.right)
        self.max = max(self.max, left + right + 1)
        return max(left, right) + 1

