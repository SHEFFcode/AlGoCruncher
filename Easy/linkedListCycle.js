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
var hasCycle = function(head) {
    let slow = head, 
        fast = head;

    while (fast && fast.next) {
        fast = fast.next.next;
        slow = slow.next;

        if (fast && slow.val === fast.val) {
            return true;
        }
    }

    return false;
};

/*
 G: Linked List
 O: Boolean does it have a cycle in it
 T: Any
 S: O(1)

1 => 2 => 3 => 4 => 5 => 4
                    *^


 */