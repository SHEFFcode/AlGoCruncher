/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  private type Mtrx = Array[Array[String]]
  private type Node = TreeNode
  def printTree(root: TreeNode): List[List[String]] = {
    val height = getHeight(root)
    val width = math.pow(2, height).toInt - 1 // first level not 2
    val res = Array.fill[String](height, width)("")

    fill(res, root, 0, 0, res(0).length)
    res.map(_.toList).toList
  }

  private def fill(res: Mtrx, cNode: Node, i: Int, l: Int, r: Int): Unit = {
    if (cNode == null) return

    res(i)((l + r) / 2) += cNode.value
    fill(res, cNode.left, i + 1, l, (l + r) / 2)
    fill(res, cNode.right, i + 1, (l + r + 1) / 2, r)
  }

  private def getHeight(root: TreeNode): Int = {
    if (root == null) 0
    else 1 + (getHeight(root.left) max getHeight(root.right))
  }
}
