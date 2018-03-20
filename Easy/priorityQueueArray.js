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

class PriorityQueue {
  constructor() {
    this.heap = [null];  // instanciate an empty container
  }

  /**
   * Inserts an item into priority queue
   * @param {number} value 
   * @param {number} priority 
   */
  insert(value, priority) {
    const newNode = new Node(value, priority);
    this.heap.push(newNode);
    let currentNodeIndex = this.heap.length - 1;
    let currentNodeParentIndex = Math.floor(currentNodeIndex / 2);

    while (
      this.heap.currentNodeParentIndex
      && newNode.priority > this.heap[currentNodeParentIndex].priority
    ) {
      const parent = this.heap[currentNodeParentIndex];
      [this.heap[currentNodeParentIndex], this.heap[currentNodeIndex]] = [this.heap[currentNodeIndex], this.heap[currentNodeParentIndex]];
      currentNodeIndex = currentNodeParentIndex;
      currentNodeParentIndex = Math.floor(currentNodeIndex / 2);
    }
  }


  remove() {
    if (this.heap.length < 3) {
      const toReturn = this.heap.pop(); // the only number in this heap;
      this.heap[0] = null;  // just in case we pop off null and return it we need to replace
      return toReturn;
    }

    const toRemove = this.heap[1];
    this.heap[1] = this.heap.pop(); // replace the first element with the one we just popped off
    this.currentIndex = 1;
    let [left, right] = [2 * currentIndex, 2 * this.currentIndex + 1]; // these are the indecies of children
    let currentChildIndex = this.heap[right] && this.heap[right].priority >= this.heap[left].priority ? right : left;

    /**
     * This while loop keeps moving the element from the front to the spot where its a priority match.
     */
    while (this.heap[currentChildIndex] && this.heap[this.currentIndex].priority <= this.heap[currentChildIndex].priority) {
      let currentNode = this.heap[this.currentIndex];
      let currentChildNode = this.heap[currentChildIndex];
      this.heap[currentChildIndex] = currentChildIndex;
      [this.heap[this.currentIndex], this.heap[currentChildIndex]] = [this.heap[currentChildIndex], this.heap[this.currentIndex]];
    }
    return toRemove;
  }
}