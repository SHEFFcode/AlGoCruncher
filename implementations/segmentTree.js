class SegmentTree {
  constructor(inputArr) {
    this.container = [];
    this.originalArrayLength = inputArr.length;
    this._constructSegmentTree(inputArr, this.container, 0, inputArr.length - 1, 0);
  }

  _constructSegmentTree(inputArr, segmentTree, low, high, position) {
    if (low === high) {  // down to a single element in the recursion
      segmentTree[position] = inputArr[low]; // or high whichever, they are the same
      return;
    }
    let mid = Math.floor(low + (high - low) / 2);
    this._constructSegmentTree(inputArr, segmentTree, low, mid, 2 * position + 1); // left child low to mid, position of left child
    this._constructSegmentTree(inputArr, segmentTree, mid + 1, high, 2 * position + 2); // right child mid+1 to high, position of right child
    segmentTree[position] = Math.min(segmentTree[2 * position + 1], segmentTree[2 * position + 2]); // once you have left and right child, current is min of left and right child
  }

  rangeQuery(qLow, qHigh, low = 0, high = this.originalArrayLength - 1, position = 0) {
    if (qLow <= low && qHigh >= high) {  // total overlap
      return this.container[position];
    }

    if (qLow > low && qHigh < high) {  // no overlap
      return Number.MAX_SAFE_INTEGER;
    }

    let mid = Math.floor(low + (high - low) / 2);

    return Math.min(
      this.rangeQuery(qLow, qHigh, low, mid, 2 * position + 1),
      this.rangeQuery(qLow, qHigh, mid + 1, high, 2 * position + 2)
    );

  }
}

let segmentTree = new SegmentTree([-1, 2, 4, 0]);
let result = segmentTree.rangeQuery(1, 3);
let x = 0;