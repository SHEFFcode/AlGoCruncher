/*
G: Singly linked list
O: Boolean is it a pallindrome?
T: O(n)
S: O(1)

a => b => c <= b <= a => null  => we set up a 3 node system, then reverse the nodes from midpoint
*         ^         #
a <= b <= b < a

*/

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    let fast = head, 
        slow = head;
    
    /**
     * Get to the middle of the linked list.
     */
    while (fast && fast.next) {
        fast = fast.next.next;  // moves the fast node 2 up
        slow = slow.next;  // moves the slow node 1 up
    }

    let node = null, next;
    /**
     * Reverses the linked list from the middle to the end.
     */
    while (slow) {

        /**
         * nxt = slow.next
        slow.next = node
        node = slow
        slow = nxt
         */
        next = slow.next;  // keep track of next node
        slow.next = node;  // assign slow.next to the previous node for reversal
        node = slow;  //keep track of the node to assign to slow.next in the future
        slow = next; // move the pointer
    }

    /**
     * Compare first and second halves of the linked list.
     */
    while (node) {
        if (node.val !== head.val) {
            return false;
        }
        node = node.next;
        head = head.next;
    }

    return true;
};