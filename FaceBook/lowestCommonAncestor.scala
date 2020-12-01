/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */

object Solution {
  def lowestCommonAncestor(
      root: TreeNode,
      p: TreeNode,
      q: TreeNode
  ): TreeNode = {
    traverse(root, p, q)._1
  }

  def traverse(
      cNode: TreeNode,
      p: TreeNode,
      q: TreeNode
  ): (TreeNode, Boolean) = {
    if (cNode == null) return (null, false)

    val iAmNode = p.value == cNode.value || q.value == cNode.value

    val (lNode, nodeFoundLeft) = traverse(cNode.left, p, q)
    val (rNode, nodeFoundRight) = traverse(cNode.right, p, q)

    if (lNode != null) (lNode, true)
    else if (rNode != null) (rNode, true)
    else if (nodeFoundRight && nodeFoundLeft) (cNode, true)
    else if ((nodeFoundRight || nodeFoundLeft) && iAmNode) (cNode, true)
    else (null, nodeFoundRight || nodeFoundLeft || iAmNode)
  }
}

/*
G: root: TreeNode, p: TreeNode, q: TreeNode
O: lowestCommonAncestor: TreeNode
T: O(N)
S: O(N)

Notes:
  - p will not equal q
  - p and q exist in a tree

Ex:

 */
