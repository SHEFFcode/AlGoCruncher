function productWithoutNumber(arr) {
  let result = [];
  let leftProduct = [];
  let rightProduct = [];

  for (let i = 0; i < arr.length; i++) {
    if (i === 0) {
      leftProduct[i] = 1;
    } else {
      leftProduct[i] = leftProduct[i - 1] * arr[i - 1];
    }
  }

  for (let i = arr.length - 1; i > -1; i--) {
    if (i === arr.length - 1) { //4
      rightProduct.push(1);
    } else {
      console.log(arr[i + 1], rightProduct[0]);
      rightProduct.unshift(arr[i + 1] * (rightProduct[0] || 1))
    }
  }



  for (let i = 0; i < leftProduct.length; i++) {
    result.push(leftProduct[i] * rightProduct[i]);
  }

  return result;
}


console.log(productWithoutNumber([1, 2, 3, 4, 5]));