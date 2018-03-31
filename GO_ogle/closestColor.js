function findClosestColor(color) {
  let r = _nearestDouble(color.substring(1, 3));
  let g = _nearestDouble(color.substring(3, 5));
  let b = _nearestDouble(color.substring(5, 7));
  return `#${r}${g}${b}`;
}

function _nearestDouble(color) {
  let numericColor = Number.parseInt(color, 16);
  let min = Number.MAX_SAFE_INTEGER;
  let candidate;
  let doubleArray = [0x11,0x22,0x33,0x44,0x55,0x66,0x77,0x88,0x99,0xaa,0xbb,0xcc,0xdd,0xee,0xff];

  for (let possibleCandidate of doubleArray) {
    if (Math.abs(numericColor - possibleCandidate) < min) {
      min = Math.abs(numericColor - possibleCandidate);
      candidate = possibleCandidate;
    }
  }

  return candidate.toString(16)[0];
}

console.log(findClosestColor("#09f166"));