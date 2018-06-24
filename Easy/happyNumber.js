/**
 * @param {number} n
 * @return {boolean}
 */

const visited = {}

var isHappy = function(n) {
    if (n === 1) {
        console.log(n)
        return true;
    }
    
    let digits = n.toString().split('');
    console.log(digits)
    let result = digits.reduce((accum, digit) => accum + digit * digit, 0);
    console.log(visited, n)
    if (visited.hasOwnProperty(result)) {
        return false;
    }
    
    visited[result] = true;
    return isHappy(result);
};