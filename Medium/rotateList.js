/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var rotateRight = function(head, k) {
  if (!head || !head.next) {
      return head;
  }
  let newHead = head;
  let tail = head;
  let newTail = head;
  let i = 0;
  
  while (i < k - 1) {
      newHead = newHead.next;
      i++;
  }
  
  i = 0;
  while (i < k) {
      newTail = newTail.next;
      i++;
  }
  
  while (newTail.next) {
      tail = tail.next;
      newHead = newHead.next;
      newTail = newTail.next;
  }
  
  
  newTail.next = head;
  tail.next = null;
  
  
  
  return newHead;
  
};