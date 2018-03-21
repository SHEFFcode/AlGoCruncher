/*
Class that helps implement min heap
*/

class Node {
  constructor(val, value) {
    this.val = val;
  }
}

class MaxHeap {
  constructor() {
    this.heap = [null];  // instanciate an empty container
  }

  /**
   * Inserts an item into max heap
   * @param {number} value 
   */
  insert(value) {
    const newNode = new Node(value);
    this.heap.push(newNode);
    let currentNodeIndex = this.heap.length - 1;
    let currentNodeParentIndex = Math.floor(currentNodeIndex / 2);

    while (
      currentNodeParentIndex
      && newNode.val > this.heap[currentNodeParentIndex].val
    ) {
      [this.heap[currentNodeParentIndex], this.heap[currentNodeIndex]] = [this.heap[currentNodeIndex], this.heap[currentNodeParentIndex]];
      currentNodeIndex = currentNodeParentIndex;
      currentNodeParentIndex = Math.floor(currentNodeIndex / 2);
    }
  }

  /**
   * Function to remove the min item form the top of max heap
   */
  remove() {
    if (this.heap.length < 3) {
      const toReturn = this.heap.pop(); // the only number in this heap;
      this.heap[0] = null;  // just in case we pop off null and return it we need to replace
      return toReturn;
    }

    const toRemove = this.heap[1];
    this.heap[1] = this.heap.pop(); // replace the first element with the one we just popped off
    let currentIndex = 1;
    let [left, right] = [2 * currentIndex, 2 * currentIndex + 1]; // these are the indecies of children
    let currentChildIndex = this.heap[right] && this.heap[right].val >= this.heap[left].val ? right : left;

    /**
     * This while loop keeps moving the element from the front to the spot where its a value match.
     */
    while (this.heap[currentChildIndex] && this.heap[currentIndex].val <= this.heap[currentChildIndex].val) {
      [this.heap[currentIndex], this.heap[currentChildIndex]] = [this.heap[currentChildIndex], this.heap[currentIndex]];
      currentIndex = currentChildIndex;
      [left, right] = [2 * currentIndex, 2 * currentIndex + 1];
      currentChildIndex = this.heap[right] && this.heap[right].val >= this.heap[left].val ? right : left
    }
    return toRemove;
  }
}

let heap = new MaxHeap();
heap.insert(5);
heap.insert(4);
heap.insert(3);
heap.insert(6);
heap.insert(9);
heap.insert(7);
heap.insert(1);

heap.remove();
heap.remove();
heap.remove();

let x = 0;
