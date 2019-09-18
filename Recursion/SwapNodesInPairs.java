/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode nextNext = swapPairs(head.next.next); // before we mess with anything
        ListNode root = head.next;
        root.next = head;
        root.next.next = nextNext;
        return root;
    }
}



/**
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 *  if (a == null || a.next == null) {
 *      return a;
 *  }
 * 
 *  a.next.next = swapNodes(a.next.next)
 * c.next = c.next.next
 * d.next = c
 * 
 *  ================================
 *  {
 *      nodeId: a,
 *      val = 1,
 *      pointer: b
 *  },
 * 
 *  {
 *      nodeId: b,
 *      val: 2,
 *      pointer: c
 *  },
 *  {
 *      nodeId: c,
 *      val: 3,
 *      pointer: d
 *  },
 *  {
 *      nodeId: d,
 *      val: 4,
 *      pointer: null
 *  }
 * ==================================
 * 
 * 
 * 
 *  1 -> 2 -> 3 -> 4
 *       *
 * 
 * 
 * 
 * 
 * Node tmp = cNode.next.next
 *  temp = 3
 * cNode = cNode.next
 *  2 -> 3 -> 4
 * cNode.next.next = temp
 * 1 -> 3 -> 4
 *  2 -> 3 -> 4
 * cNode.next = cNode
 * 2 -> 1 -> 3 -> 4
 * 
 * recurse (cNode.next.next)
 * 
 */