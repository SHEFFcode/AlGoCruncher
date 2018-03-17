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
var getIntersectionNode = function (headA, headB) {
  let aTravel = 0,
    bTravel = 0,
    difference = 0,
    acNode = headA,
    bcNode = headB;
  
  if (!headA || !headB) {
    return null;
  }

  while (acNode && bcNode) {  // while we still have some space to advance to
    aTravel++;
    bTravel++;
    if (acNode === bcNode) {  // this would mean both nodes have the same distance to the merge point
      return acNode;
    }
    acNode = acNode.next;
    bcNode = bcNode.next;
  }

  difference = aTravel - bTravel;

  if (difference > 0) {
    while (difference > -1) {
      headA = headA.next;
      difference--;
    }
  } else {
    while(difference < 1) {
      headB = headB.next;
      difference++;
    }
  }

  while (headA !== headB && headA && headB) {
    headA = headA.next;
    headB = headB.next;
  }

  if (headA === headB) {
    return headA;
  } else {
    return null;
  }
};

/*
G: ListNode, ListNode => linked list head, linked list head
O: ListNode => node where two linked list intersect
T: O(n)
S: O(1)

Notes:
* If there is no intersection, return null
* Linked lists must retain their structure after the function returns
* There are not cycles in the entire structure

Solution:
             *           
      A1 => A2 =>                      *     => 5
                    C1 => C2 => C3 => null
B1 => B2 => B3 =>               ^            => 6
             ^                 
 */