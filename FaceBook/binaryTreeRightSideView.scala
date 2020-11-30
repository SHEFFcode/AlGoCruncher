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
  def rightSideView(root: TreeNode): List[Int] = {
    if (root == null) return List[Int]()
    val brain = HashMap[Int, Int]()

    traverse(root, brain, 0)
    brain.values.toList
  }

  def traverse(root: TreeNode, brain: HashMap[Int, Int], level: Int): Unit = {
    if (root != null) return ()
    if (!brain.contains(level)) {
      brain(level) = root.value
    }

    traverse(root.right, brain, level + 1)
    traverse(root.left, brain, level + 1)
  }
}

/*
G: root: TreeNode
O: rightSideView: List[Int]
T: any
S: Any

Notes:
  - Imagine you stand on the right hand side of the tree, tell us what you see
  - An alternative solution is BFS with two queues, so that you know once you have
    run out of the items in the queue, you have the right most element.

Ex:

   1            <---
 /   \
2     3         <---
 \
  5    <---

[1, 3, 5]

{
  0: 1
  1: 3
  2: 5
}

hashSet.values

 */
