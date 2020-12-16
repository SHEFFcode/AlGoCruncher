/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def countNodes(root: TreeNode): Int = {
    if (root == null) 0
    else countNodes(root.left) + countNodes(root.right) + 1
  }
}

/*
G: root: TreeNode
O: totalNodes: Int
T: O(n)
S: O(1)

Notes:
  - Definition of complete binary tree:
    ^ In a complete binary tree every level, except possibly the last,
      is completely filled, and all nodes in the last level are as far
      left as possible. It can have between 1 and 2h nodes inclusive
      at the last level h.

Ex:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

 */
