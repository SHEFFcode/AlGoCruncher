object Solution {
  def isPalindrome(s: String): Boolean = {
    if (s.size < 2) return true

    // 1) Filter out punctuation, including spaces
    // "AmanaplanacanalPanama"
    val filteredString = s.filter(_.isLetterOrDigit)

    // 2) make everything lowercase
    // "amanaplanacanalpanama"
    val lowerCased = filteredString.toLowerCase()

    // 3) Set two pointers and run down the length of the string until i > j
    var i = 0
    var j = lowerCased.length() - 1

    while (i <= j) { // danger zone, make sure to change vars
      if (lowerCased(i) != lowerCased(j)) {
        return false
      }
      i += 1 // increment i
      j -= 1 // decrement j
    }

    // 4) Return true of the items match, false if they do not
    true
  }
}

/*
Input: "A man, a plan, a canal: Panama"

Output: true


Approach:
0) If the length is < 2, just return true
1) Filter out punctuation, including spaces
"AmanaplanacanalPanama"
"raceacar"
""
2) make everything lowercase
"amanaplanacanalpanama"
""
3) Set two pointers and run down the length of the string until i > j
a m a n a p l a n a c a n a l p a n a m a
                      i
                 j


r a c e a c a r
      i
        j

""
4) Return true of the items match, false if they do not
true
false
 */
