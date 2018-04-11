/**
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function(n) {
  if (!n) {
      return [];
  }
  let string = '';
  let container = [];
  let i = 1;
  
  while (i < n + 1) {
      string = '';
      if (i % 3 === 0) {
          string = 'Fizz';
      }
      if (i % 5 === 0) {
          string += 'Buzz';
      }
      if (!string) {
          string += i;
      }
      container.push(string);
      i++;
  }
  return container;
};

console.log(fizzBuzz(3));