/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    let hayPointer = 0, needlePointer = 0, index = -1;

    if (!needle) {
        return 0;
    } else if (needle.length > haystack.length) {
        return -1;
    }

    while (hayPointer < haystack.length && needlePointer < needle.length) {
        if (needle[needlePointer] === haystack[hayPointer]) {
            if (index === -1) {
                index = hayPointer;
            }
            hayPointer++;
            needlePointer++;
        } else {
            hayPointer++;
            needlePointer = 0;
            index = -1;
        }
    }

    return index;
};

console.log(strStr("mississippi", "issip"));

/*
G: String, String haystack, needle
O: 2
T: Any
S: Any

ex: hello, ll
      *    ^
Once we have a match with the first letter in the needle, we check for the rest of the needle


Case1: we do not match with the first character, so we take note of the index and move hayPointer forward
Case2: we match with the first needle character, so we move hayPointer and needlePointer forward
Case3: we run out of needle length => return index
Case4: we get a mismatch, so we reset the needlePointer
Case5: we run out of haystack => return -1
*/