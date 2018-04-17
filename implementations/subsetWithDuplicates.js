/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function (nums) {
  nums.sort((a, b) => a - b);
  let brain = {};
  var result = [[]];

  for (var i = 0; i < array.length; i++) {
    //this line is crucial! It prevents us from infinite loop
    var len = result.length;
    for (var x = 0; x < len; x++) {
      let key = result[x].concat(array[i]);
      if (!brain.hasOwnProperty(key)) {
        result.push(result[x].concat(array[i]))
        brain[key] = true;
      }
    }
  }

  return result;
};