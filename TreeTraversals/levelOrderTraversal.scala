import scala.collection.mutable.Queue

/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) return Nil
    val q = Queue[TreeNode](root)
    var ans = List[List[Int]]()

    while (!q.isEmpty) {
      var cLevel = List[Int]()
      for (_ <- 0 until q.size) {
        val cNode = q.dequeue
        cLevel :+= cNode.value
        Option(cNode.left).map(q.enqueue(_))
        Option(cNode.right).map(q.enqueue(_))
      }
      ans :+= cLevel
    }

    ans
  }
}
