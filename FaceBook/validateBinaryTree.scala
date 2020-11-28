/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def isValidBST(
      root: TreeNode,
      min: TreeNode = null,
      max: TreeNode = null
  ): Boolean = {
    if (root == null) true
    else if (min != null && root.value <= min.value) false
    else if (max != null && root.value >= max.value) false
    else {
      isValidBST(root.left, min, root) && isValidBST(root.right, root, max)
    }
  }
}

/*
G: root: TreeNode
O: isSearchTree: Boolean
T: O(n)
S: O(n)

Notes:
  - Conditions for search tree:
    ^ The left subtree of a node contains only nodes with keys less than the node's key.
    ^ The right subtree of a node contains only nodes with keys greater than the node's key.
    ^ Both the left and right subtrees must also be binary search trees

Ex:
    2
   / \
  1   3

Input: [2,1,3]
Output: true


Ex2:
    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

 */
