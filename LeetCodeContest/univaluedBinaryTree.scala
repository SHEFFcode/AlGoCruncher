/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def isUnivalTree(root: TreeNode): Boolean = {
        def traverse(cNode: TreeNode, value: Int): Boolean = {
          if (cNode == null) true
            else if (cNode.value != value) false
          else traverse(cNode.left, value) && traverse(cNode.right, value)
        }

        traverse(root, root.value)
    }
}