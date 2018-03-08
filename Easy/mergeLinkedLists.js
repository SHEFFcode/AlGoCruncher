/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    let start = new ListNode(0);  // this is just a temp node, we will return start.next
    let firstListNode = l1;
    let secondListNode = l2;
    let currentNode = start;
    
    while (firstListNode && secondListNode) {
        if (firstListNode.val <= secondListNode.val) {
            currentNode.next = firstListNode;
            currentNode = currentNode.next;
            firstListNode = firstListNode.next;
        } else {
            currentNode.next = secondListNode;
            currentNode = currentNode.next;
            secondListNode = secondListNode.next;
        }
    }
    
    if (!firstListNode && secondListNode) {
        while (secondListNode) {
            currentNode.next = secondListNode;
            currentNode = currentNode.next;
            secondListNode = secondListNode.next;
        } 
    } else if (!secondListNode && firstListNode) {
        while(firstListNode) {
            currentNode.next = firstListNode;
            currentNode = currentNode.next;
            firstListNode = firstListNode.next;
        }
    }
    
    
    return start.next;
};

/*

1->2->4, 1->3->4
*        ^

somenode -> 1 -> 1 -> 2 -> 3 -> 4 -> 4 ->

*/