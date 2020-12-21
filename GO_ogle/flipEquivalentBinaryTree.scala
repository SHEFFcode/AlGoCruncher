/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def flipEquiv(root1: TreeNode, root2: TreeNode): Boolean = {
    if (root1 == root2)
      return true // by definition its the same tree, works for null too
    if (root1 == null || root2 == null || root1.value != root2.value) {
      return false
    }
    flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
    flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
  }
}

/*
G: root1: TreeNode, root2: TreeNode
O: areFlipEquivalent: Boolean
T: O(min(N1N2)) (Number of nodes of the shorter tree)
S: O(min(H1H2))

Notes:
  -  Flip operation: choose any node, and swap the left and right child subtrees.
  - A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
    ^ This means children are either in the same order, or in flipped order


Ex:

 */
