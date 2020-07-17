/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function (arr1, arr2) {
  let output = []
  let endArr = []
  let cache = {}

  arr2.forEach((item) => {
    if (cache[item]) {
      cache[item]++
    } else {
      cache[item] = 1
    }
  })

  arr1.forEach((item) => {
    if (cache[item]) {
      cache[item]++
    } else {
      endArr.push(item)
    }
  })

  arr2.forEach((item) => {
    if (cache[item]) {
      if (cache[item]) {
        let newArr = new Array(cache[item] - 1).fill(item)
        output.push(...newArr)
      }
    }
  })

  return output.concat(endArr.sort((a, b) => a - b))
}

/*
  [2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19] # arr1
          
  [2, 1, 4, 3, 9, 6] # arr2
      i

  output = []
  let endArr = []

  cache = {
    '2': 3,
    '3': 2,
    '1': 1,
    '4': 1,
    '6': 1,
    '7': 1,
    '9': 1,
    '19': 1
  }


  if (cache[arr2[i]]) {
    let newArr = new Array(arr2[i]).fill(cache[arr2[i]])
    ouput.concat(newArr)
  } else {
    endArr.push(arr2[i])
  }


  return output.concat(endArr.sort((a,b) => a - b))

  */
