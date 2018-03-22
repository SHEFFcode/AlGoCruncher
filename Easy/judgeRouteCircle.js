/**
 * @param {string} moves
 * @return {boolean}
 */
var judgeCircle = function(moves) {
  let horizontalMove = 0;
  let verticalMove = 0;
  
  for (let char of moves) {
      if (char === 'U') {
          verticalMove++;
      } else if (char === 'D') {
          verticalMove--;
      } else if (char === 'L') {
          horizontalMove++;
      } else if (char === 'R') {
          horizontalMove--;
      }
  }
  
  return horizontalMove === 0 && verticalMove === 0;
};