function compareStrings(str1, str2) {
  if (_inputValid(str1, str2)) {
    let convertedString = _convertToString(str1);
    return (_compareStrings(convertedString, str2));
  }
}

function _compareStrings(needle, haystack) {
  let needlePointer = 0;
  let hayStackPoiner = 0;
  let hayStackPlace = 0;

  while (hayStackPoiner < haystack.length - needle.length) {
    if (haystack[hayStackPoiner] === needle[needlePointer]) {
      if (needlePointer === needle.length) {
        return true;
      }
      needlePointer++;
      hayStackPoiner++;
    } else {
      needlePointer = 0;
      hayStackPoiner = hayStackPlace;
      hayStackPlace++;
    }
  }
  return false;
}

function _convertToString(str) {
  let indexOfOperator = str.indexOf('\\');
  let operator = str.charAt(indexOfOperator + 1);
  if (!~indexOfOperator) {
    if (operator === 'b') {
      str = str.slice(0, indexOfOperator - 1);
    } else if (operator = 'c') {
      str = str.slice(0, indexOfOperator - 1) + str[indexOfOperator + 2].toUpperCase();
    }
  }
  return str;
}

function _inputValid(str1, str2) {
  return true;
}