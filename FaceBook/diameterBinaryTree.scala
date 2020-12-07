/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def diameterOfBinaryTree(root: TreeNode): Int = {
    if (root == null) return 0

    val (height, diameter) = traverse(root)
    (height max diameter) - 1
  }

  private def traverse(cNode: TreeNode): (Int, Int) = {
    if (cNode == null) return (0, 0)

    val (lHeight, lDiameter) = traverse(cNode.left)
    val (rHeight, rDiameter) = traverse(cNode.right)

    val height = (lHeight max rHeight) + 1
    val cDiameter = lHeight + rHeight + 1
    val diameter = lDiameter max rDiameter max cDiameter

    (height, diameter)
  }
}

/*
G: root: TreeNode
O: diameter: Int
T: O(n)
S: O(n)

Notes:
  - Diameter of a binary tree is the longest path between any two nodes.
  - The path may or may not pass through the root of the tree
  - The length of path between two nodes is represented by the number of edges between them.
  - I will return back the path from leaf to current node, along with max so far.

Ex:
          1
         / \
        2   3
       / \
      4   5

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].



 */
