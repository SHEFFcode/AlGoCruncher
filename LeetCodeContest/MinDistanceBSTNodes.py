# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minDiffInBST(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        c_node = root
        min_dist = [-1]
        cont = []

        def traverse(current_node, min_distance, container):
            if current_node is not None:
                distance_right = abs(current_node.val - current_node.right.val) if current_node.right is not None else -1
                distance_left = abs(current_node.val - current_node.left.val) if current_node.left is not None else -1
                if min_distance[0] < 0 or (min_distance[0] > distance_right > 0):
                    min_distance[0] = distance_right
                    for item in container:
                        current_distance_other_nodes = abs(item - distance_right)
                        if current_distance_other_nodes < min_distance[0]:
                            min_distance[0] = current_distance_other_nodes
                if min_distance[0] < 0 or (min_distance[0] > distance_left > 0):
                    min_distance[0] = distance_left
                    for item in container:
                        current_distance_other_nodes = abs(item - distance_left)
                        if current_distance_other_nodes < min_distance[0]:
                            min_distance[0] = current_distance_other_nodes
                if distance_right > -1:
                    container.append(current_node.right.val)
                if distance_left > -1:
                    container.append(current_node.left.val)
                traverse(current_node.left, min_distance, container)
                traverse(current_node.right, min_distance, container)
        traverse(c_node, min_dist, cont)
        if min_dist[0] < 1:
            min_dist[0] = 1
        return min_dist[0]