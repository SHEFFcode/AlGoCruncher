/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
  let stones = S;
  let jewels = J;
  
  let setOfLettersRepresentingJewels = new Set();
  let numberOfJewels = 0;
  
  for (let char of jewels) {
      setOfLettersRepresentingJewels.add(char);
  }
  
  for (let char of stones) {
      if (setOfLettersRepresentingJewels.has(char)) {
          numberOfJewels++;
      }
  }
  
  return numberOfJewels;
};