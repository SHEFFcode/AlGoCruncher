/**
 * @param {string} num
 * @return {boolean}
 */
var isStrobogrammatic = function (num) {
  const strobogrammicPairs = {
    '6': '9',
    '8': '8',
    '9': '6',
    '1': '1',
    '0': '0',
  }

  let start = 0
  let end = num.length - 1

  while (start <= end) {
    if (start === end) {
      return num[start] === '1' || num[start] === '8' || num[start] === '0'
    }
    let leftNum = num[start]
    let rightNum = num[end]
    console.log(rightNum)
    if (
      !strobogrammicPairs[leftNum] ||
      strobogrammicPairs[leftNum] !== rightNum
    ) {
      return false
    }
    start++
    end--
  }

  return true
}

/*
strobogrammicPairs = {
  "6": "9",
  "8": "8",
}


let start = 0
let end - num.length

while (start < end) {
  let leftNum = num[start]
  let rightNum = num[end]
  if (!strobogrammicPairs[leftNum] || strobogrammicPairs[leftNum] === rightNum) {
      return false
  }
}

return true




*/
