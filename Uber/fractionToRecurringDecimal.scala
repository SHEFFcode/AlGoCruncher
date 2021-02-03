import scala.math.Integral.Implicits._
import scala.math._

object Solution {
  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    val sign = if (signum(numerator) * signum(denominator) == -1) "-" else ""
    s"${sign}${fractionToDecimal(abs(numerator.toLong), abs(denominator.toLong))}"
  }

  private def fractionToDecimal(numerator: Long, denominator: Long): String = {
    numerator /% denominator match {
      case (quot, 0) => quot.toString // simple number like 4 / 2
      case (quot, rem) =>
        s"${quot}.${generateFractional(rem, denominator)}" // more complex 3 / 2
    }
  }

  @scala.annotation.tailrec
  private def generateFractional(
      numerator: Long,
      denominator: Long,
      numeratorToIndex: Map[Long, Int] = Map(),
      fractional: String = ""
  ): String = {
    numeratorToIndex.get(numerator) match {
      case Some(
            index
          ) => // we had a number like this, say 3.357357357, gets another 3
        s"${fractional.substring(0, index)}(${fractional.substring(index)})"
      case _ =>
        10 * numerator /% denominator match {
          case (quot, 0) => fractional + quot // found an end
          case (quot, rem) =>
            generateFractional(
              rem,
              denominator,
              numeratorToIndex + (numerator -> fractional.length), // how many spots post .
              fractional + quot
            )
        }
    }
  }
}

/*
G: numerator: Int, denominator: Int
O: recurringDecimal: String
T:
S:

Notes:
  - If the fractional part is repeating, enclose the repeating part in parentheses.
  - If multiple answers are possible, return any of them.
  - It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

Ex:
Input: numerator = 1, denominator = 2
Output: "0.5"

Ex2:
Input: numerator = 2, denominator = 1
Output: "2"

Ex3
Input: numerator = 2, denominator = 3
Output: "0.(6)"

Ex4
Input: numerator = 4, denominator = 333
Output: "0.(012)"

Ex5
Input: numerator = 1, denominator = 5
Output: "0.2"

 */
