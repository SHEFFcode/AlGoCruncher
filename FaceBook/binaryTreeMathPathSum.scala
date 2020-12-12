object Solution {
  def maxPathSum(root: TreeNode): Int = {
    var maxPathSum = Int.MinValue

    def traverse(cNode: TreeNode): Int = {
      if (cNode == null) return 0
      val leftPath = traverse(cNode.left)
      val rightPath = traverse(cNode.right)
      maxPathSum = maxPathSum max (leftPath + cNode.value + rightPath)

      (cNode.value + (leftPath max rightPath)) max 0
    }

    traverse(root)
    maxPathSum
  }
}
