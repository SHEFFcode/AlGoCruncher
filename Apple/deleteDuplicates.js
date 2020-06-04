/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function (head) {
  if (!head) return head

  let cNode = head
  let nextNode = head
  let pNode = new ListNode(-1)
  let dummy = pNode
  pNode.next = head

  while (cNode) {
    nextNode = cNode.next
    if (nextNode == null || cNode.val != nextNode.val) {
      if (pNode.next == cNode) {
        pNode = cNode
      } else {
        pNode.next = nextNode
      }
    }

    cNode = nextNode
  }

  return dummy.next
}

/*
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
      if (head == null) return head;
      ListNode cur = head;
      ListNode nxt = head;
      ListNode pre = new ListNode(-1);
      ListNode dummy = pre;
      pre.next = head;
      
      while (cur != null) {
          nxt = cur.next;
          if (nxt == null || cur.val != nxt.val) {
              if (pre.next == cur) {
                  pre = cur;
              } else {
                  pre.next = nxt;
              }
          } 
          cur = nxt;
      }
      return dummy.next;
  }
}

*/
