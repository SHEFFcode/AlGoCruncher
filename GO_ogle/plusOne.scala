object Solution {
  def plusOne(digits: Array[Int]): Array[Int] = {
    for (i <- digits.length - 1 to 0 by -1) {
      digits(i) match {
        case 9 => digits(i) = 0
        case _ => {
          digits(i) = digits(i) + 1
          return digits
        }
      }
    }
    // if we got here it's all 9s
    Array(1) ++ digits
  }
}

/*
G: digits: Array[Int]
O: digitsPlusOne: Array[Int]
T: O(N)
S: O(N) for the returned array

Notes:
  - Non empty array
  - Decimal digits
  - Each element contains a single digit
  - No leading zeros except number 0 itself

Ex1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

1 2 3
    i

nums(i) match {
  case 9 => nums(i) = 0
  case _ =>  {
    nums(i) = nums(i) + 1 // Array(1, 2, 4)
    return nums
  }
}

Ex2:
Input: digits = [0]
Output: [1]

0

nums(i) match {
  case 9 => nums(i) = 0
  case _ =>  {
    nums(i) = nums(i) + 1 // Array(1)
    return nums
  }
}

Ex3:
Input: digits = [9, 9, 9]
Output: [1, 0, 0, 0]

9 9 9

nums(i) match {
  case 9 => nums(i) = 0 // Array(0, 0, 0)
  case _ =>  {
    nums(i) = nums(i) + 1 // Array(1)
    return nums
  }
}

// if we got here it's all zeros
Array(1) ++ nums

Ex4:
Input: digits = [8, 9, 9]
Output: [9, 0, 0]

8 9 9

nums(i) match {
  case 9 => nums(i) = 0 // Array(8, 0, 0)
  case _ =>  {
    nums(i) = nums(i) + 1 // Array(9, 0, 0)
    return nums
  }
}

// if we got here it's all zeros
Array(1) ++ nums

 */
