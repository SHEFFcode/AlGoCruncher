/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
  if (!headA || !headB) {
    return null
  }
  let aNode = headA
  let bNode = headB
  let leaderNode
  let followerNode

  while (aNode || bNode) {
    if (aNode === bNode) {
      return aNode
    }
    if (!aNode || !bNode) {
      if (!leaderNode) {
        leaderNode = aNode ? headA : headB
        followerNode = aNode ? headB : headA
      }
      leaderNode = leaderNode.next
    }
    aNode = aNode ? aNode.next : null
    bNode = bNode ? bNode.next : null
  }

  while (leaderNode !== followerNode && leaderNode) {
    leaderNode = leaderNode.next
    followerNode = followerNode.next
  }

  return leaderNode
}

// Another way to do this.

var getIntersectionNode = function(headA, headB) {
  var pointerA = headA
  var pointerB = headB

  while (pointerA !== pointerB) {
    pointerA = pointerA === null ? headB : pointerA.next
    pointerB = pointerB === null ? headA : pointerB.next
  }

  return pointerA
}
