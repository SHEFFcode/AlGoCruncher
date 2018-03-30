function addOne(arr) {
  for (let i = arr.length - 1; i > -1; i--) {
    if (arr[i] < 9) {
      arr[i]++;
      return arr;
    } else if (arr[i] === 9 && i === 0) {
      arr[i] = 0;
      arr.unshift(1);
      return arr;
    } else if (arr[i] === 9) {
      arr[i] = 0;
    }
  }
  return -1;
}

console.log(addOne([8,9,9,9]));