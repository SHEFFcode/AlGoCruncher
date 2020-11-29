/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */
object Solution {
  def maxPathSum(root: TreeNode): Int = {
    var maxSum = Int.MinValue

    def traverse(cNode: TreeNode): Int = {
      if (cNode == null) return 0
      val leftGain = traverse(cNode.left) max 0
      val rightGain = traverse(cNode.right) max 0
      val newPathSum = cNode.value + rightGain + leftGain
      maxSum = maxSum max newPathSum

      cNode.value + (leftGain max rightGain)
    }

    traverse(root)
    maxSum
  }
}

/*
G: root: TreeNode
O: maxPathToSum: Int
T: ???
S: ???

Notes:
  - The tree is guaranteed to be non empty
  - A path is from the root node to any node in the tree using parent child connections
  - Path must contain at least 1 node, and does not have to go through the root
  - What is we keep the sum with me and without me, and just keep rolling?

Ex:

withMe: 5
withoutMe: 3

    1
   / \
  2   3

=> 6

 */
