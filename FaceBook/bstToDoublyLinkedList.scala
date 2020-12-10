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
    // tail will be the 5 node in the following list: 1 <=> 2 <=> 3 <=> 4 <=> 5
    // so to find head we want to go as left as possible till we hit null
    val head = findHead(tail)

    // make the final link from head to tail and vice versa
    head.left = tail
    tail.right = head

    head
  }

  private def buildListReturnTail(cNode: Node, prevNode: Node): Node = {
    if (cNode == null)
      return prevNode // we want tail (rightmost node), so if I am null, the tail is my parent

    // the tail node of the left tree, which will be rightmost element of that subtree
    val leftTail = buildListReturnTail(cNode.left, prevNode)

    if (leftTail != null) {
      cNode.left = leftTail // connect me to the tail of left subtree
      leftTail.right = cNode // reverse connection in a doubly linked list
    }

    // cNode here will be the previous node
    // so that cNode becomes the back up tail node
    // in case the right child is null.
    buildListReturnTail(cNode.right, cNode)
  }

  private def findHead(cNode: Node): Node = {
    if (cNode == null) return null
    if (cNode.left == null) return cNode
    findHead(cNode.left) // we go left from tail to head
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
