function numberOfPaths(length, width) {
  if (_inputValid(length, width)) {
    return _traverse(0, 0, length, width);
  }
}

function _traverse(i, j, length, width) {
  if (i === length - 1 && j === width - 1) {
    return 1;
  } else if (i === length - 1 || j === width - 1 || i < 0 || j < 0) {
    return 0;
  }
  return (
    _traverse(i, j + 1, length, width) +
    _traverse(i - 1, j + 1, length, width) +
    _traverse(i+ 1, j + 1, length, width)
  ); 
}

function _inputValid(n, m) {
  return true;
}

console.log(numberOfPaths(4, 5));

/*
0 0 0
0 0 0 
0 0 0
*/