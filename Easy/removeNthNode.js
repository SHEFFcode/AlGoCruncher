/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    let start = new ListNode(0);
    let slowNode = start;
    let fastNode = start;
    start.next = head;
    
    for (let i = 1; i <= 1 + n; i++) {
        fastNode = fastNode.next;
    }

    while (fast !== null) {
        slow = slow.next;
        fast = fast.next;
    }

    slow.next = slow.next.next;
    return start.next;
};


/*
G: LinkedList and int node value
O: return LinkedList without the node
T: O(n)
S: O(1)

Notes:
* n will always be valid
* Do in one pass

Solution:
Case1: node is the node I am looking for:
    move the value of the next node into current node
    make node.next = node.next.next
    break
Case2: node is not the node I am looking for:
    increment counter


1 -> 2 -> 3 -> 4 -> 5 -> null
               *         ^

checkForNull(node, n);
*/