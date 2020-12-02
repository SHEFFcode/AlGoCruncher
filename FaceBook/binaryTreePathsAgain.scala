import scala.collection.mutable.ListBuffer

/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def binaryTreePaths(root: TreeNode): List[String] = {
    val treePaths = ListBuffer[String]()
    traverse(root, Nil, treePaths)
    treePaths.toList
  }

  def traverse(
      cNode: TreeNode,
      cPath: List[Int],
      treePaths: ListBuffer[String]
  ): Unit = {
    if (cNode != null) {
      if (cNode.left == null && cNode.right == null) {
        treePaths += (cPath :+ cNode.value).mkString("->")
      } else {
        traverse(cNode.left, cPath :+ cNode.value, treePaths)
        traverse(cNode.right, cPath :+ cNode.value, treePaths)
      }
    }
  }
}

/*
G: root: TreeNode
O: binaryTreePaths: List[String]
T: Any
S: Any

Notes:
  - given a tree, return all root-to-leaf paths

Ex:

 */
