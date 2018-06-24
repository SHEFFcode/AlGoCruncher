# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
import collections

class Solution:
    def verticalOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        root.level = 0
        hash = {}
        result = []
        self.bfs(root, hash)

        for key, value in hash:
            result.append(value)
        return result


    def bfs(self, root, hash):

        root.right.level = root.level + 1
        root.left.level = root.level - 1
        queue = collections.deque()
        queue.append(root)
        cNode = root
        while cNode:
            if not cNode:
                break
            cNode = queue.popleft()
            if cNode.level in hash:
                hash[cNode.level].append(cNode)
            else:
                hash.update({cNode.level: [cNode]})
            if cNode.left:
                queue.append(cNode.left)
            if cNode.right:
                queue.append(cNode.right)