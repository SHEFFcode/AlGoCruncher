function lonelyNumber(arr) {
  return arr.reduce((a, b) =>{
    return a ^ b;
  });
}

console.log(lonelyNumber([2, 1, 2, 1, 3]));