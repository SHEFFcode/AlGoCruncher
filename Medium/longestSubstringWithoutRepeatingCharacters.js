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