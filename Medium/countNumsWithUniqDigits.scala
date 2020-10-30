object Solution extends App {
  def countNumbersWithUniqueDigits(n: Int): Int = {
    if (n == 0) 1
    else {
      val sum_ = (9 until 10 - n by -1).foldLeft((10, 9)) {
        case ((count, product), digit) => {
          val cCount = product * digit
          (count + cCount, cCount)
        }
      }

      sum_._1
    }
  }

  println(countNumbersWithUniqueDigits(4))
}

/*
G: n: Int
O: countNumsUniqDigit: Int
T: O(n)
S: O(n)

Notes:
 * Given integer will be non negative
 * This could be done via brute force with DP
 * Could also be done via combinatorics

Ex1:
n = 1

0 <= x <= 10 ^ 1 so 10 ways 0 to 9

Ex2:
n = 2

0<= x <= 10 ^ 2, so 10 ways to do 1 number + y ways to do 2 numbers

_ _ we can do the first digit 9 ways (can't be 0) we can do the second digit 9 ways (0 + remaining 8 numbers)

so 10 + (9 * 9) = 10 + 81 = 91 ways
 */
