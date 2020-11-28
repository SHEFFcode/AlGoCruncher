/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def flatten(root: TreeNode): Unit = {
    traverse(root)
  }

  def traverse(cNode: TreeNode): TreeNode = {
    if (cNode == null) return null
    if (cNode.left == null && cNode.right == null) {
      return cNode
    }
    val leftNode = traverse(cNode.left)
    val rightNode = traverse(cNode.right)

    if (leftNode != null) {
      leftNode.right = cNode.right
      cNode.right = cNode.left
      cNode.left = null
    }

    if (rightNode == null) leftNode else rightNode
  }
}

/*
G: root: TreeNode
O: flattenedRoot: TreeNode
T: Any
S: Any

Notes:
  - Just need to be a single list heading right

Ex:
    1
   / \
  2   5
 / \   \
3   4   6

=>

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

 */
