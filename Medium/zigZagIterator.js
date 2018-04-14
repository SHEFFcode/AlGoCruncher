/**
 * @constructor
 * @param {Integer[]} v1
 * @param {Integer[]} v1
 */
var ZigzagIterator = function ZigzagIterator(v1, v2) {
  this.container = [];
  this.currentIndex = 0;
  let sizeIdentifier = [];
  sizeIdentifier.push(v1, v2);
  let longestInput = 0;
  sizeIdentifier.forEach((input) => {
    if (input.length > longestInput) {
      longestInput = input.length;
    }
  });
  let i = 0;

  while (i < longestInput) {
    for (let item of sizeIdentifier) {
      if (item[i] !== null && item[i] !== undefined) {
        this.container.push(item[i]);
      }
    }
    i++;
  }
  let x = 0;
};


/**
 * @this ZigzagIterator
 * @returns {boolean}
 */
ZigzagIterator.prototype.hasNext = function hasNext() {
  return (this.currentIndex < this.container.length);
};

/**
 * @this ZigzagIterator
 * @returns {integer}
 */
ZigzagIterator.prototype.next = function next() {
  if (this.hasNext()) {
    let item = this.container[this.currentIndex];
    this.currentIndex++;
    return item;
  }
};

var i = new ZigzagIterator([0], [0]), a = [];
while (i.hasNext()) a.push(i.next());
let x = 0;