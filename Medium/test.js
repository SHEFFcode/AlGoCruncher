function countAppetizersThatAddToTotal(arr, target) {

  let collectionOfItems = [];
  let tempCollection = [];

  _traverse(arr, target, 0, collectionOfItems, tempCollection);

  return collectionOfItems;
}

function _traverse(arr, target, price, resultCollection, tempCollection) {

  if (target === 0) {

    resultCollection.push(tempCollection.slice());
    console.log(resultCollection)
    return;
  } else if (target < 0) {
    tempCollection.pop();
    return;
  }

  arr.forEach((price) => {
      let temp = tempCollection.slice();
      temp.push(price);
    _traverse(arr, target - price, price, resultCollection, temp);
  });


}

let result = countAppetizersThatAddToTotal([2.15, 2.75, 3.35, 3.55, 4.20, 5.80], 15.05);
console.log(result);

