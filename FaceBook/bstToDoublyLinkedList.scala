/**
  * Definition for a Node.
  * class Node(var _value: Int) {
  *   var value: Int = _value
  *   var left: Node = null
  *   var right: Node = null
  * }
  */

object Solution {
  def treeToDoublyList(root: Node): Node = {
    if (root == null) return root

    val tail = buildListReturnTail(root, null)
    println(runtime.ScalaRunTime.stringOf(tail))
    val head = findHead(tail)

    head.left = tail
    tail.right = head

    head
  }

  private def buildListReturnTail(cNode: Node, prevNode: Node): Node = {
    if (cNode == null)
      return prevNode // we want tail, so if I am null, the tail is my parent

    val leftTail =
      buildListReturnTail(
        cNode.left,
        prevNode
      ) // the tail node of the left tree, which will be rightmost element of that subtree
    cNode.left = leftTail // connect me in order to the tail of left subtree
    if (leftTail != null) {
      leftTail.right = cNode // do the second connection in a doubly linked list
    }

    val rightTail =
      buildListReturnTail(
        cNode.right,
        cNode
      ) // cNode here will be the previous node
    rightTail // we will just return the right tail to be processed by the next parent.
  }

  private def findHead(cNode: Node): Node = {
    if (cNode == null) return null
    if (cNode.left == null) return cNode
    findHead(cNode.left)
  }
}

/*
G: root: Node
O: DoublyLinkedListHead: Node
T: O(n)
S: O(n)

Notes:
  - All values of node.val are unique

Ex:

                  4
                /  \
               2    5
              / \
             1  3

1 <=> 2 <=> 3 <=> 4 <=> 5
 */
