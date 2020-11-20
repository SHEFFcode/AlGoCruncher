object Solution extends App {
  def nextClosestTime(time: String): String = {
    val hoursAndMins = time.split(":")
    val sTimeInMinutes = hoursAndMins(0).toInt * 60 + hoursAndMins(1).toInt
    val digits = Set[Int]() ++ time.filter(_ != ':').map(_.asDigit)
    var elapsed = 24 * 60
    var nextClosestTime = sTimeInMinutes

    for {
      h1 <- digits; h2 <- digits if ((h1 * 10 + h2) < 24)
      m1 <- digits; m2 <- digits if ((m1 * 10 + m2) < 60)
    } yield {
      val cTimeInMinutes = 60 * (h1 * 10 + h2) + (m1 * 10 + m2)
      val minsElapsed = Math.floorMod(cTimeInMinutes - sTimeInMinutes, 24 * 60)
      if (minsElapsed > 0 && minsElapsed < elapsed) {
        nextClosestTime = cTimeInMinutes
        elapsed = minsElapsed
      }
    }
    f"${nextClosestTime / 60}%02d:${nextClosestTime % 60}%02d"
  }

  println(nextClosestTime("01:32"))
}

/*
G: time: String
O: nextClosestTimeFromSameDigits: String
T: O(N)
S: O(1)

Notes:
  - Given time represented by format HH:MM, form the next closest time by reusing current digits
  - For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
  -

Ex1:
Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.

19:34 => 19:39, which is 5 mins later

{
  1
  9
  3
  4
}

1, 3, 4, 9

19:34

val firstHalf = [19] => till 24
val secondHalf = [34] => till 60

if (secondHalf(1) != 9) {
  val second = secondHalf(1)
  val availableDigits = sortedSet.values.filter(_ > second)
  if (availableDigits.length) {
    val newSecondHalf = secondHalf(0) + secondHalf(1)
    return firstHalf:secondHalf
  }
} else if (secondHalf(0) != 5) {
  val second = sortedSet(0)
  val availableDigits = sorted.filter(x => x > secondHalf(0) && x < 6)
  if (availableDigits.length > 0) {
    val newSecondHalf = availableDigits(0) + second
    return firstHalf:newSecondHalf
  }
} else if (firstHalf(1) != 3) {
  val availableDigits = sortedSet.values.filter(_ > firstHalf(1) && _ < 4)
  if (availableDigits.length > 0) {
    val second = availableDigits(0)
    val newFirst = firstHalf(0) + second
    val newSecondHalf = sortedSet.values(0) + sortedSet.values(0)
    return newFirst + second:newsSecondHalf
  }
} else if (firstHalf(0) < 2) {
  val first = 2
  val availableDigits = sortedSet.values.filter(_ > firstHalf(1) && _ < 4)
  if (availableDigits.length > 0) {
    val newFirstHalf = first + availableDigits(0)
    val newSecondHalf = sortedSet.values(0) + sortedSet.values(0)
    return newFirstHalf:newSecondHalf
  }
} else {
  val digit = sortedValues(0)
  return digits + digit : digit + digit
}




 */
