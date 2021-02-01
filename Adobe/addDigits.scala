object Solution {
  def addDigits(num: Int): Int = {
    if (num == 0) 0
    else if (num % 9 == 0) 9
    else num % 9
  }
}

/*
G: num: Int
O: modulo: Int
T: O(1)
S: O(1)

Notes:
  - This relates to the fact that 9 is the largest single digit number
  - Therefore we dance from it as described in the algo above.

Ex:

 */
