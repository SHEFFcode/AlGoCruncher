/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
  var resultStr = (x ^ y);  // xor 5 ^ 1 = 0101 ^ 0001 = 0100
  let count = 0;
  while (resultStr > 0) {
     resultStr = (resultStr & resultStr - 1); 
     count++;
  }
   return count;
};