/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    let j = 0;
    for (let i = 0; i < matrix.length; i++) {
        let nextSpot = findNext(matrix, i, j)
    }
};

function findNext(matrix, currentPosition, rotationIndex) {
    let nextPosition = [];
    if (j === 0) {
        nextPosition = [matrix.length - 1, 0]
    } else if (j === matrix.length - 1) {
        nextPosition = [i, matrix.length - 1]
    }
}

/*
G: nxn 2d matrix
O: nxn matrix rotated 90 degrees to the right
T: Any
S: O(1)

Given input matrix = 
[
   [1,2,3],
    *
   [4,5,6],

   [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Given input matrix =
[  is
  [ 5, 1, 9,11], js

  [ 2, 4, 8,10],

  [13, 3, 6, 7],

  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

*/