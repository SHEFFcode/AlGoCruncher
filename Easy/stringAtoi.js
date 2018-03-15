/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    let sum = 0;
    let power = 0;
    let multiplier = 1;
    let lookupTable = { 45: -1, 48: 0, 49: 1, 50: 2, 51: 3, 52: 4, 53: 5, 54: 6, 55: 7, 56: 8, 57: 9 };

    for (let i = 0; i <= str.length; i++) {
        if (!lookupTable.hasOwnProperty(str.charCodeAt(i)) && !power) {
            continue;
        } else if (!lookupTable.hasOwnProperty(str.charCodeAt(i)) && !!power) {
            return sum;
        } else if (lookupTable.hasOwnProperty(str.charCodeAt(i))) {
            if (str.charCodeAt(i) === 45 && !power) {
                multiplier = -1;
            } else if (str.charCodeAt(i) === 45 && !!power) {
                return sum;
            }
            sum *= 10;
            sum += lookupTable[str.charCodeAt(i)];
            power++;
        }
    }

    return sum;
};

myAtoi("      1234556px    ");

/*
G: String => string containing a number.
O: Number => converted from a string representation, ignoring whitespace and any letter characters after
T: Any
S: Any

12345px => 12345  [Number.Parse()]

48 49 50 51 52 53 54 55 56 57 
0  1  2  3  4  5  6  7  8  9


'     12345px    '
           *


*/