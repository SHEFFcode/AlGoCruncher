/**
 * @param {number[]} A
 * @return {number}
 */
var peakIndexInMountainArray = function(A) {
  let index
  A.reduce((accumulator, currentValue, currentIndex) => {
    if (currentValue > accumulator) {
      accumulator = currentValue
      index = currentIndex
      return accumulator
    }
    return accumulator
  })

  return index
} // just doing this to stay green
