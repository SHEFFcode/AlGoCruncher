object Solution extends App {
  def isPowerOfTwo(n: Int): Boolean = {
    if (n == 0) {
      return false
    }

    var num = n
    while (num % 2 == 0) {
      num /= 2
    }

    return n == 1
  }
}

/*
Input: 1
Output: true
Explanation: 2^0 = 1


Input: 16
Output: true
Explanation: 2^4 = 16


var result = false
(0 to (16 / 2)).foreach(i => {
  println(i)
  if ((2 ^ i) == n) return true)
}

return result
 */
