/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
// class TreeNode(
//     _value: Int = 0,
//     _left: TreeNode = null,
//     _right: TreeNode = null
// ) {
//   var value: Int = _value
//   var left: TreeNode = _left
//   var right: TreeNode = _right
// }

object Solution {
  def binaryTreePaths(root: TreeNode): List[String] = {
    traverseTree(root, List[String](), "")
  }

  def traverseTree(
      cNode: TreeNode,
      allPaths: List[String],
      pathToCNode: String
  ): List[String] = {
    if (cNode == null) return List[String]()

    val cPath = pathToCNode match {
      case "" => s"${cNode.value}"
      case _  => s"${pathToCNode}->${cNode.value}"
    }

    if (cNode.left == null && cNode.right == null) {
      // we are at leaf node
      allPaths :+ cPath
    } else {
      traverseTree(cNode.right, allPaths, cPath) ++
        traverseTree(cNode.left, allPaths, cPath)
    }
  }
}

/*
G: binaryTreeRoot: TreeNode
O: rootToLeafPaths: List[String]
T: O(dw)
S: O(dw)

Notes:
  - Leaf node is a node with no children
  - The output will be a string path with "->" string between nodes
  - Choose explore un choose kind of thing
    ^ Base case is when you have no right or left child.
    ^ You keep a string of nodes you have seen so far in the recursion
    ^ Once you have reached the leaf node, you return it, and then you add both your children to the output list

Ex:
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

 */
