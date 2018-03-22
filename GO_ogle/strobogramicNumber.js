/**
 * @param {number} n
 * @return {string[]}
 */
var findStrobogrammatic = function (n) {
  return generatePermutations(n, n);
};

function generatePermutations(m, n) {
  if (m === 0) return [''];
  if (m === 1) return ['0', '1', '8'];

  let t = generatePermutations(m - 2, n);
  let res = [];

  for (let item of t) {
    if (m !== n) res.push('0' + item + '0');
    res.push('1' + item + '1');
    res.push('6' + item + '9');
    res.push('8' + item + '8');
    res.push('9' + item + '6');
  }

  return res;
}