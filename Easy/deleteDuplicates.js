/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function (head) {
  if (!head) {
    return head;
  }
  let cNode = head;

  while (cNode.next) {
    if (cNode.val === cNode.next.val) {
      cNode.next = cNode.next.next;
    } else {
      cNode = cNode.next;
    }
  }

  return head;

};