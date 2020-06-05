/**
 * @param {number[]} arr
 * @return {number}
 */
var maxNumberOfApples = function (arr) {
  let remainingCapacity = 5000
  arr.sort((a, b) => a - b) // sort is in place
  let countOfApples = 0

  arr.some((appleWeight) => {
    remainingCapacity = remainingCapacity - appleWeight
    if (remainingCapacity > 0) {
      countOfApples++
    } else {
      return true
    }
  })

  return countOfApples
}

/*
  [100, 200, 150, 1000]  maxWeight = 5000 lelt's sort this arr first
  
  [100, 150, 200, 1000] now that we are sorted, we will just subtract from 5000 untill we hit -
  
  5000 - 100 = 4900   1
  4900 - 150 = 4750   2
  4750 - 200 = 4550   3
  4550 - 1000 = 3550  4
  
  while we are doing this we will increment the number of apples
  
  
  [900,950,800,1000,700,800]
  [700,800,800,900,950,1000]
  
  5000 - 700  1
  4300 - 800  2
  3500 - 800  3
  2700 - 900  4
  1800 - 950  5
  850 - 1000 = negative

*/
