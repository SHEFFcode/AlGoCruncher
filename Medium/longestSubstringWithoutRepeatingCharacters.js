/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    let longestSubstringNoRepeat = 0
    for (let i = 0, len = s.length; i < len; i++) {
        let letterSet = new Set()
        letterSet.add(s[i])
        let localMax = 1
        for (let j = i + 1; j < len; j++) {
            if (!letterSet.has(s[j])) {
                localMax++
                letterSet.add(s[j])
            } else {
                break
            }
        }
        if (localMax > longestSubstringNoRepeat) {
            console.log(letterSet)
            longestSubstringNoRepeat = localMax
        }
    }
    return longestSubstringNoRepeat
};

/*
    Fast Solution
*/

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    let len = s.length;
    if (len === 0 || len === 1) return len;
    let longest = 0;
    let start = 0;

    for (let end = 0; end < s.length; end++) {
        const curr = s[end];
        const index = s.indexOf(curr, start);
        if (index >= start && index < end) {
            start = index + 1;
        } else {
            longest = Math.max(longest, end - start);
        }
    }

    return longest + 1;
};