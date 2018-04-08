/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  if (strs.length === 0) {
    return "";
  }
  let prefix = '';
  let currentLetter = '';
  let i = 0;

  while (true) {
    for (let string of strs) {
      if (i >= string.length) {
        break;
      }
      if (string.length === 0) {
        return "";
      }
      if (currentLetter.length === 0) {
        currentLetter = string[i];
      }
      if (string[i] !== currentLetter) {
        return prefix;
      }

    };

    prefix += currentLetter;
    currentLetter = '';
    i++;
    if (i >= strs.length - 1) {
      return prefix
    }
  }
};



longestCommonPrefix(["a", "a", "a"]);