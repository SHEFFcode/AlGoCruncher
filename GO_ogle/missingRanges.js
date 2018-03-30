function missingRanges(arr) {
  if (_inputValid(arr)) {
    let small = 0,
    big = 99,
    missingIntervals = [];
    arr.sort( (a, b) => a - b);

    for (var i = 0; i < arr.length; i++) {
      if (small === arr[i]) {
        small++;
      } else {
        missingIntervals.push(`${small}${arr[i] - 1 !== small ? ' -> ' + (arr[i] - 1) : ''}`);
        small = arr[i] + 1;
      }
    }

    if (arr[i - 1] !== big) {
      missingIntervals.push(`${arr[i - 1] + 1} -> ${big}`);
    }
    return missingIntervals;
  }
  return null;
}

function _inputValid(arr) {
  return !!arr || !(arr.length === 0);
}

console.log(missingRanges([0, 1, 2, 4, 50]));