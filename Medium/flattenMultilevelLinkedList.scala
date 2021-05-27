/**
  * Definition for a Node.
  * class Node(var _value: Int) {
  *   var value: Int = _value
  *   var prev: Node = null
  *   var next: Node = null
  *   var child: Node = null
  * }
  */

object Solution {
  def flatten(head: Node): Node = {
    if (head == null) return head

    var cNode = head

    while (cNode != null) {
      if (cNode.child != null) {
        var tail = childTail(flatten(cNode.child)) // recursive call
        // let's connect the children
        // to remaining nodes at this stack frame
        if (cNode.next != null) {
          tail.next = cNode.next
          cNode.next.prev = tail
        }

        // connect current node to the head
        // of the children stack frame
        cNode.next = cNode.child
        cNode.next.prev = cNode
        cNode.child = null // set child to null to prevent cycles
        cNode =
          tail.next // let's move on to node after the tail, we are done with this segment
      } else cNode = cNode.next
    }

    head
  }

  /**
    * Finds the last node of the children
    * so that they can be connected to remaining
    * next nodes of the current stack frame.
    * @param cHead
    */
  */
  private def childTail(cHead: Node): Node = {
    var cNode = cHead
    while (cNode.next != null) {
      cNode = cNode.next
    }
    cNode
  }
}
