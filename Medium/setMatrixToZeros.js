/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function (matrix) {
    for (let i = 0, height = matrix.length; i < height; i++) {
        for (let j = 0, width = matrix[0].length; j < width; j++) {
            if (matrix[i][j] === 0) {
                turnToNull(matrix, i, j, height)
            }
        }
    }

    for (let i = 0, height = matrix.length; i < height; i++) {
        for (let j = 0, width = matrix[0].length; j < width; j++) {
            if (matrix[i][j] === null) {
                matrix[i][j] = 0
            }
        }
    }

    return matrix
};

const turnToNull = (matrix, i, j, height) => {
    matrix[i] = matrix[i].map(item => {
        if (item !== 0) {
            return null
        } else {
            return 0
        }
    })
    for (let h = 0; h < height; h++) {
        if (matrix[h][j] !== 0) {
            matrix[h][j] = null
        }
    }
}