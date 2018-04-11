/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function(n) {
  let allNumbers = Array(n + 1).fill(1);
    let count = 0;
  
  allNumbers[0] = 0;
  allNumbers[1] = 0;
  
  for (let i = 2; i <= Math.sqrt(n); i++) {
      if (allNumbers[i] === 1) { // if a number is prime, all its multiples are not
        for(let j = 2; i * j <= n; j++) {
          allNumbers[i * j] = 0;
        }
      }
  }
    
    allNumbers.forEach((number) => {
        if (number === 1)
            count++;
    });
  return count;
};

countPrimes(2);