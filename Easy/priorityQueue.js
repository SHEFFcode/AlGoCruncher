/*
Class that helps implement min heap
*/

class Node {
  constructor(val, priority) {
    this.val = val;
    this.priority = priority;
    this.next = null;
  }
}

/*
The queue itself implemented as a linked list [O(n) insertion, O(1) deletion]
*/
class PriorityQueue {
  constructor() {
    this.first = null;
  }

  insert(value, priority) {
    const newNode = new Node(value, priority);
    if (!this.first || priority > this.first.priority) {  // we have something with higher priority then head node
      newNode.next = this.first;
      this.first = newNode;
    } else {
      let pointer = this.first;
      while (pointer.next && priority < pointer.next.priority) {  // let's find a node whose priority is just higher then ours
        pointer = pointer.next;
      }

      newNode.next = pointer.next;
      pointer.next = newNode;
    }
  }

  remove() {
    const first = this.first; // keep track of first as it is
    this.first = this.first.next;  // update the first to be its next
    return first;
  }
}