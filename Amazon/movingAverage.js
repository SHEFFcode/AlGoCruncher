/**
 * Initialize your data structure here.
 * @param {number} size
 */
var MovingAverage = function (size) {
  this.queue = []
  this.size = size
}

/**
 * @param {number} val
 * @return {number}
 */
MovingAverage.prototype.next = function (val) {
  if (this.queue.length === this.size) {
    this.queue.shift()
  }
  this.queue.push(val)

  const sum = this.queue.reduce((acc, item) => {
    if (item) {
      acc += item
    }
    return acc
  })

  const result = sum / this.queue.length

  console.log(result)

  return result
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = new MovingAverage(size)
 * var param_1 = obj.next(val)
 */

/*
  queue [undefined, undefined, undefined] arr of size 3
  
  .next(1)
  
  [1, undefined, undefined]
  
  let numberOfItems = 1 // has to be at least 1
  
  const sum = queue.reduce((acc, item) => {
      if (item) {
          acc += item
          numberOfItems++
      }
  })
  
  return sum / numberOfItems
  
  

*/
