/**
 * @param {number} n
 * @return {string[]}
 */
var findStrobogrammatic = function (n) {
  return generatePermutations(n, n);
};

function generatePermutations(cLevel, originalLength) {
  if (cLevel === 0) return [''];
  if (cLevel === 1) return ['0', '1', '8'];

  /*
  -2 here to keep odds and evens separate. 
  So for odd permutations it's 0, 1, 8 && 1_1, 6_9, 8_8, 9_6
  for evens ONLY 1__1, 6__9, 8__8, 9__6
  */
  let permutations = generatePermutations(cLevel - 2, originalLength);  // see above for -2 explanation
  let stroboNumbers = [];

  for (let permutation of permutations) {
    if (cLevel !== originalLength) stroboNumbers.push('0' + permutation + '0'); // root level, we only want to add zeroes in that case
    stroboNumbers.push('1' + permutation + '1');
    stroboNumbers.push('6' + permutation + '9');
    stroboNumbers.push('8' + permutation + '8');
    stroboNumbers.push('9' + permutation + '6');
  }

  return stroboNumbers;
}

console.log(findStrobogrammatic(2));