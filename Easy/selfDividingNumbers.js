/**
 * @param {number} left
 * @param {number} right
 * @return {number[]}
 */
var selfDividingNumbers = function(left, right) {
  let selfDividingContainer = [];
  while (left <= right) {
      let cNum = left;
      let divider = left;
      while (true) {
          if (divider === 0) {
              selfDividingContainer.push(left);
              break;
          }
          if (cNum % 10 === 0 || cNum % (divider % 10) !== 0) {
              break;
          }
          
          divider = Math.floor(divider / 10);
      }
      left++;
  }
  return selfDividingContainer;
};