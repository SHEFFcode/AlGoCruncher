function combineStrings(str1: string, str2: string): string {
  let length = Math.max(str1.length, str2.length);
  let combinedString = '';
  let str1Pointer = 0,
  str2Pointer = 0;

  while (str1Pointer < str1.length || str2Pointer < str2.length) {
    if (str1[str1Pointer] && str2[str2Pointer]) {
      if (str1.charCodeAt(str1Pointer) <= str2.charCodeAt(str2Pointer)) {
        combinedString += str1[str1Pointer];
        str1Pointer++;
      } else {
        combinedString += str2[str2Pointer];
        str2Pointer++;
      }
    } else {
      if (str1) {
        combinedString += str1.substring(str1Pointer);
        break;
      } else if (str2) {
        combinedString += str2.substring(str2Pointer);
        break
      }
    }
  }

  return combinedString;
}

console.log(combineStrings('abc', 'akmw'));