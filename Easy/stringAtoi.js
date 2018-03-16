/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    let index = 0, sign = 1, total = 0;

    if (str.length === 0) {  // just input check
        return 0;
    }

    // Removes the spaces
    while (str.charAt(index) === ' ' && index < str.length) {
        index++;
    }

    if (str.charAt(index) == '+' || str.charAt(index) === '-') {
        sign = str.charAt(index) === "+" ? 1 : -1;
        index++;
    }

    while (index < str.length) {
        digit = str.charAt(index) - '0';
        if (digit < 0 || digit > 9 || digit !== digit || str.charAt(index) === ' ') {
            break;
        }

        //Check for integer overflow
        if ((Math.pow(2, 31) - 1) / 10 < total 
            || (Math.pow(2, 31) - 1) / 10 === total && (Math.pow(2, 31) - 1) % 10 < digit) {
                return sign === 1 ? (Math.pow(2, 31) - 1) : (Math.pow(2, 31) - 1);
        }
        total = total * 10 + digit;
        index++;
    }
    if (total !== total) {
        return 0;
    }

    if (total > 2147483647) {
        total = 2147483647;
    } else if (total < -2147483647) {
        total = 2147483647;
    }

    return total * sign;
};

console.log(myAtoi("    -0012a42"));

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