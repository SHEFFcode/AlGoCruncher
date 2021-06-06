import scala.collection.mutable.HashMap

/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def verticalTraversal(root: TreeNode): List[List[Int]] = {
    val map =
      HashMap[Int, List[(Int, Int)]]() // Tree map will keep keys in asc order

    def assignCoordinates(cNode: TreeNode, x: Int = 0, y: Int = 0): Unit = {
      if (cNode == null) return ()

      // We will process nodes from top to bottom, so y only goes up
      assignCoordinates(cNode.left, x - 1, y + 1) // Process left child
      assignCoordinates(cNode.right, x + 1, y + 1) // Process right child

      // here we will append to existing list current value, location
      // so { x -> (nodeVal, y) }
      map += (x -> ((cNode.value, y) :: map.getOrElse(x, Nil)))
    }

    assignCoordinates(root)

    // let's sort such that we sort first by yPos and then by node value
    val cmp = (a: (Int, Int), b: (Int, Int)) => {
      val (aNodeValue, aNodeYPos) = a
      val (bNodeValue, bNodeYPos) = b
      // sort each x bucket (list of all values for given x) by yPosition first, and
      // then by the nodeValue itself
      aNodeYPos < bNodeYPos || (aNodeYPos == bNodeYPos && aNodeValue < bNodeValue)
    }

    map.values.toList.map(_.sortWith(cmp)).map(a => a.map(x => x._1))
  }
}
