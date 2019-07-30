/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def countNodes(root: TreeNode): Int = {
        if (root == null) 0

        def calcNodes(cNode: TreeNode, nodeCount: Int = 0): Int = {
          if (cNode == null) return nodeCount
          val leftSubtreeHeight = calculateSubtreeHeight(cNode.left)
          val rightSubtreeHeight = calculateSubtreeHeight(cNode.right)

          if (leftSubtreeHeight == rightSubtreeHeight) calcNodes(cNode.right, nodeCount + (1 << rightSubtreeHeight))
          else calcNodes(cNode.left, nodeCount + (1 << rightSubtreeHeight))
        }

        calcNodes(root)
    }

    private def calculateSubtreeHeight(cNode: TreeNode, height: Int = 0): Int = {
      if (cNode != null) calculateSubtreeHeight(cNode.left, height + 1)
      else height
    }
}

object Solution {
  def countNodes(root: TreeNode) = {
    if (root == null) 0
    else countNodes(root.left) + countNodes(root.right) + 1
  }
}