/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function (n) {
    let num = 0
    while (n) {
        num++
        n &= n - 1
    }

    return num
};