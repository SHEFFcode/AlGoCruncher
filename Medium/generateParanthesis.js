/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
  let result = [];
  addingParanthesis(result, "", n, 0);
  return result;
};

function addingParanthesis(result, parensSoFar, leftToAdd, rightToAdd) {
  if (leftToAdd === 0 && rightToAdd === 0) {
    result.push(parensSoFar);
    return;
  }

  if (rightToAdd > 0) {
    addingParanthesis(result, parensSoFar + ')', leftToAdd, rightToAdd - 1);
  }

  if (leftToAdd > 0) {
    addingParanthesis(result, parensSoFar + '(', leftToAdd - 1, rightToAdd + 1);
  }
}

generateParenthesis(3);