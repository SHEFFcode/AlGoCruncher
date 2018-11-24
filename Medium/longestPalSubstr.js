/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
  const len = s.length
  if (len < 2) {
    return s
  }
  const table = createTable(len)
  let palindromeStartStopTuple = [0, 1]
  for (let i = 0; i < len; i++) {
    table[i][i] = true
  }

  // check for sub-string of length 2
  for (let i = 0; i < len - 1; i++) {
    if (s[i] === s[i + 1]) {
      table[i][i + 1] = true
      start = i
      palindromeStartStopTuple = [i, i + 1 + 1]
    }
  }

  // k is the length of the substring. This checks for lengths greater then 2
  for (let k = 3; k <= len; k++) {
    for (let i = 0; i < len - k + 1; i++) {
      let j = i + k - 1 // is the ending index of a string starting at i of length k
      if (table[i + 1][j - 1] && s[i] === s[j]) {
        table[i][j] = true
        if (k > palindromeStartStopTuple[1] - palindromeStartStopTuple[0]) {
          palindromeStartStopTuple = [i, j + 1]
        }
      }
    }
  }

  return s.substring(palindromeStartStopTuple[0], palindromeStartStopTuple[1])
}

function createTable(len) {
  return new Array(len)
    .fill(undefined)
    .map(() => new Array(len).fill(undefined))
}

// Other Solution
/**
 * @param {string} s
 * @return {string}
 */
const longestPalindrome = str => {
  let longest = ''

  for (let i = 0; i < str.length; i++) {
    let head = i
    let tail
    let count

    while (str[i] === str[i + 1]) {
      i++
    }

    tail = i
    count = tail - head + 1

    for (
      let offset = 1;
      head - offset > -1 && tail + offset < str.length;
      offset++
    ) {
      if (str[head - offset] !== str[tail + offset]) break
      count += 2
    }

    if (count >= longest.length) {
      longest = str.substr(head - (count - (tail - head + 1)) / 2, count)
    }
  }

  return longest
}

/**
 * @param {string} s
 * @return {string}
 */
const longestPalindrome = str => {
  let longest = ''

  for (let i = 0; i < str.length; i++) {
    let head = i
    let tail
    let offset = 0
    let count

    while (str[i] === str[i + 1]) {
      i++
    }

    tail = i
    count = tail - head + 1

    for (
      offset = 1;
      head - offset > -1 && tail + offset < str.length;
      offset++
    ) {
      if (str[head - offset] !== str[tail + offset]) {
        break
      }
      count += 2
    }

    if (count >= longest.length) {
      longest = str.substr(head - (offset - 1), count) //back out 1 because we break the loop at the unmodified value of offset
    }
  }

  return longest
}
