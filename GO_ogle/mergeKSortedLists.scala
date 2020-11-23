/**
  * Definition for singly-linked list.
  * class ListNode(_x: Int = 0, _next: ListNode = null) {
  *   var next: ListNode = _next
  *   var x: Int = _x
  * }
  */
object Solution {
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    val k = lists.size
    var interval = 1 // good starting interval, consider every list
    val l: Array[ListNode] = lists.clone() // let's node mod input
    while (interval < k) {
      for (i <- 0 until (k - interval) by (interval * 2)) {
        l(i) = merge2Lists(l(i), l(i + interval))
      }
      interval *= 2 // we will grow the interval as we merge lists
    }

    if (k > 0) l(0) else null
  }

  def merge2Lists(list1: ListNode, list2: ListNode): ListNode = {
    val head = ListNode(-1) // head node to be discarded
    var cNode = head
    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
      if (l1.x <= l2.x) {
        cNode.next = l1
        l1 = l1.next
      } else {
        cNode.next = l2
        l2 = l2.next
      }
      cNode = cNode.next
    }

    if (l1 == null) {
      cNode.next = l2
    } else {
      cNode.next = l1
    }

    head.next // discard first node
  }
}

// class ListNode(_x: Int = 0, _next: ListNode = null) {
//   var next: ListNode = _next
//   var x: Int = _x
// }

/*
G: lists: Array[ListNode]
O: sortedLinkedList: ListNode
T: O(N)
S: O(N)

Notes:
  - Each linked list is in ascending order
  - Merge all linked lists into a single linked list

Ex:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

[[1,4,5],[1,3,4],[2,6]]

value: []
reference: []


[1, 1, 2, 3, 4, 4, 5, 6]
 */
