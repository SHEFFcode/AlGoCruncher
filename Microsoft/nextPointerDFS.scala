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
  var leftMost: Node = null
  var prev: Node = null

  private def processChild(childNode: Node): Unit = {
    if (childNode != null) {
      if (prev != null) {
        prev.next = childNode
      } else {
        leftMost = childNode
      }

      prev = childNode
    }

  }

  def connect(root: Node): Node = {
    if (root == null) return root
    leftMost = root
    var cNode = leftMost

    while (leftMost != null) {
      prev = null
      cNode = leftMost
      leftMost = null

      while (cNode != null) {
        processChild(cNode.left)
        processChild(cNode.right)

        cNode = cNode.next
      }
    }

    root

  }
}

/*
G: root: Node
O: rootWithNextPopulated: Node
T: O(N)
S: O(1) we will not count stack frames as extra space

Notes:
  - If there is no next right node, the next pointer should be set to NULL.
  - Initially, all next pointers are set to NULL.

Ex:

 */
