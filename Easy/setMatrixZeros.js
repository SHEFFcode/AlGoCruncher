/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    
};

let traverseMatrix = function (xIndex, yIndex, matrix) {
    if (matrix[xIndex][yIndex] !== 0) {
        traverseMatrix(xIndex, yIndex++, matrix);
    }
}

/*
G: int[][] m x n matrix
O: void, set the row and column to 0 if first element is 0
T: Any
S: O(1)

[
    [1, 2, 3, 4, 5],
     
    [0, 1, 2, 3, 4],
     *
    [4, 1, 0, 3, 4],

    [0, 1, 2, 3, 4]
]

*/