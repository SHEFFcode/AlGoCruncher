class Node {
  constructor(value) {
    this.val = value;
  }
}

class MinHeap {
  constructor() {
    this.heap = [null];
  }

  /**
   * Method to insert a number into min heap
   * @param {Number} value 
   */
  insert(value) {
    const newNode = new Node(value);
    this.heap.push(newNode);
    let currentIndex = this.heap.length - 1;
    let currentParentIndex = Math.floor(currentIndex / 2);

    while (
      this.heap[currentParentIndex]
      && this.heap[currentParentIndex].val > this.heap[currentIndex].val
    ) {
      [this.heap[currentParentIndex], this.heap[currentIndex]] = [this.heap[currentIndex], this.heap[currentParentIndex]];
      currentIndex = currentParentIndex;
      currentParentIndex = Math.floor(currentIndex / 2);
    }
  }

  remove() {
    if (this.heap.length < 3) {
      const toReturn = this.heap.pop();
      this.heap[0] = null;
      return toReturn;
    }

    const toReturn = this.heap[1];
    this.heap[1] = this.heap.pop();
    let currentIndex = 1;
    let [left, right] = [2 * currentIndex, 2 * currentIndex + 1];
    let currentChildIndex = this.heap[right] && this.heap[right].val <= this.heap[left].val ? right : left;

    while (this.heap[currentChildIndex] && this.heap[currentChildIndex].val <= this.heap[currentIndex].val) {
      [this.heap[currentChildIndex], this.heap[currentIndex]] = [this.heap[currentIndex], this.heap[currentChildIndex]];
      currentIndex = currentChildIndex;
      [left, right] = [2 * currentIndex, 2 * currentIndex + 1];
      currentChildIndex = this.heap[right] && this.heap[right].val <= this.heap[left].val ? right : left;
    }

    return toReturn;
  }
}

let heap = new MinHeap();
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