import scala.collection.mutable.ListBuffer

object Solution {
  def removeKdigits(num: String, k: Int): String = {
    var stack = ListBuffer[Char]()

    var (digits, toRemove) = num.foldLeft(stack, k) {
      case ((stack, left2Remove), digit) => {
        var left = left2Remove
        while (stack.size > 0 && left > 0 && stack.last > digit) {
          // remove elements from stack while the last item is bigger then cDigit
          stack.remove(stack.size - 1)
          left -= 1
        }
        // add digit if its monotonically increasing
        stack += digit
        (stack, left)
      }
    }

    for (i <- 0 until toRemove) {
      stack.remove(stack.size - 1)
    }

    val res = stack.mkString.dropWhile(_ == '0')

    if (res.isEmpty) "0" else res
  }
}

/*
G:
O:
T:
S:

Notes:

Ex:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

 */
