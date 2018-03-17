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
var oddEvenList = function (head) {
  let oddHead = null,
    oddTail = null,
    evenHead = null,
    evenTail = null,
    cNode = head;
  while (cNode) {
    if (cNode.val % 2 === 0) { // even
      if (!evenHead) {
        evenHead = cNode;
        evenTail = cNode;
      } else {
        evenHead.next = evenTail;
        evenTail.next = cNode;
        evenTail = evenTail.next;
      }
    } else {  // odd
      if (!oddHead) {
        oddHead = cNode;
        oddTail = cNode;
      } else {
        oddHead.next = oddTail;
        oddTail.next = cNode;
        oddTail = oddTail.next;
      }
    }
    cNode = cNode.next;
  }

  oddTail.next = evenHead;
  return oddHead;
};

/*
G: ListNode head node to a singly linked list of ints
O: ListNode head not to a singly linked list of ints where odds are first, evens second
T: O(n)
S: O(1)

Notes:
* Relative order of odds and evens remains the same


oddHead = firstOdd
oddEven = firstEven
keep track of the two and add them up
then just point the oddHead.tail to evenHead

*/