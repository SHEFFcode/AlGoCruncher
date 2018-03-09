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
var reverseList = function(head) {
    return doReverse(head);
};

function doReverse(current_node) { //3
    if (current_node === null || current_node.next === null) {
        return current_node; // this is the case for an empty linked list.
    }
    let nextNode = current_node.next; //4
    let newHead = doReverse(nextNode); //5
    nextNode.next = current_node; // 2 -> 1
    current_node.next = null; // 2 -> 1 -> null
    return newHead; //5
}
/*
G: SinglyLinkedList
O: SinglyLinkedList, reversed

null <- 1 <- 2 -> 3 -> 4 -> 5 -> null
*                   ^

5 -> 1 -> 2 -> 3 -> 4 -> null
          *         ^
          


*/