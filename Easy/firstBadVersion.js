/**
 * Definition for isBadVersion()
 * 
 * @param {integer} version number
 * @return {boolean} whether the version is bad
 * isBadVersion = function(version) {
 *     ...
 * };
 */

/**
 * @param {function} isBadVersion()
 * @return {function}
 */
var solution = function(isBadVersion) {
    /**
     * @param {integer} n Total versions
     * @return {integer} The first bad version
     */
    return function(n) {
	        let l = 0, r = n - 1;

	        while (l <= r) {
        	    let midpoint = Math.round(l + (r - l) / 2, 0);
                
		        if (isBadVersion(midpoint)) {
			        r = midpoint - 1;
		        } else {
			        l = midpoint + 1;
		        }
	        }
	
	        return l;
    };
};



/*
G: int[] versions, api: bool isBadVersion(version): boolean whether or not version is bad
O: function that returns int first bad one.
T: Any
S: Any

//1, 2, 3, 4, 5


3 => bad version
look @ midpoint to the left

3=> good version
look @ midpoint to the right

Solution: This is sort of a binary search where we need to check the midpioint to see whether or not that value is failing or not, if it is failing we look left, if not look left.

Case1: isBadVersion === true:
	look left
Case2: isBadVersion === false:
	look right


*/

/*
[1, 2, 3, 4x, 5x, 6x, 7x, 8x, 9x]
          r   l r                           


*/
