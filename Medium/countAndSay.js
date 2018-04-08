/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function (n) {
  let string = '1';
  let cString = '';
  let count = 1;
  let int = 1;

  for (let j = 0; j < n - 1; j++) {
    for (let i = 0; i < string.length; i++) {
      int = string[i];
      if (string[i + 1] === string[i]) {
        count++;
      } else {
        cString += count.toString() + int.toString();
        count = 1;
      }
    }
    string = cString;
    cString = '';
    count = 1;
  }

  return string;
};

console.log(countAndSay(6));