  /**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */
  object Solution {
    def hasPathSum(root: TreeNode, sum: Int): Boolean = {
        if (root == null) return false
      def hasPathSumHelper(cNode: TreeNode, sum: Int, sumSoFar: Int): Boolean = {
          println(sumSoFar)
        if (cNode == null) false
        else if ((cNode.value + sumSoFar) == sum && cNode.left == null && cNode.right == null) true
        else hasPathSumHelper(cNode.right, sum, sumSoFar + cNode.value) || hasPathSumHelper(cNode.left, sum, sumSoFar + cNode.value)
      }
      hasPathSumHelper(root, sum, 0)
    }
  }