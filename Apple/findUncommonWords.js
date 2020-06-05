/**
 * @param {string} A
 * @param {string} B
 * @return {string[]}
 */
var uncommonFromSentences = function (A, B) {
  const uncommonWords = []
  const set = {}

  const aWords = A.split(' ')
  const bWords = B.split(' ')
  const allWords = [...aWords, ...bWords]

  allWords.forEach((word) => {
    if (set[word]) {
      set[word]++
    } else {
      set[word] = 1
    }
  })

  const keys = Object.keys(set)
  keys.forEach((key) => {
    if (set[key] < 2) {
      uncommonWords.push(key)
    }
  })

  return uncommonWords
}

/*
  [this, apple, is, sweet]    [this, apple, is, sour]
                                                #

  {
      this: 2,
      apple: 2,
      is: 2,
      sweet: 1
  }



  [sour, sweet]
*/
