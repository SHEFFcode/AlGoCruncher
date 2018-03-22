/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number[]}
 */
var anagramMappings = function(A, B) {
  let map = {};
  let mappingArray = [];
  
  for (let i = 0; i < B.length; i++) {
      map[B[i]] = i;
  }
  
  for (let i = 0; i < A.length; i++) {
      mappingArray[i] = map[A[i]];
  }
  
  return mappingArray;
};