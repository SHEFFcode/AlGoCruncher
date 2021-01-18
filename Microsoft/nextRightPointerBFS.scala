import scala.collection.mutable.Queue

/**
  * Definition for a Node.
  * class Node(var _value: Int) {
  *   var value: Int = _value
  *   var left: Node = null
  *   var right: Node = null
  *   var next: Node = null
  * }
  */

object Solution {
  def connect(root: Node): Node = {
    if (root == null) return root
    val q = Queue(root)

    while (q.nonEmpty) {
      val cLevelSize = q.size

      for (i <- 0 until cLevelSize) {
        val cNode = q.dequeue

        // We don't want to grab an element from next level
        if (i < cLevelSize - 1) {
          cNode.next = q.front
        }

        if (cNode.left != null) q += cNode.left
        if (cNode.right != null) q += cNode.right
      }
    }

    root
  }
}

/*
G: root: Node
O: rootWithNextPopulated: Node
T: O(N)
S: O(n) for the queue

Notes:
  - If there is no next right node, the next pointer should be set to NULL.
  - Initially, all next pointers are set to NULL.

Ex:

 */
