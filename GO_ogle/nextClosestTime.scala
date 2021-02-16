object Solution {
  def nextClosestTime(time: String): String = {
    val Array(hours, minutes) = time.split(":")
    val sTimeInMinutes = hours.toInt * 60 + minutes.toInt
    val digits = Set[Int]() ++ time.filter(_ != ':').map(_.asDigit)
    var elapsed = 24 * 60 // max time that could have elapsed in minutes
    var nextClosestTime = sTimeInMinutes // for now let's set it to start time

    for {
      h1 <- digits; h2 <- digits; hours <- h1 * 10 + h2
      if (hours < 24) // _ _ is less than 24
      m1 <- digits; m2 <- digits; minutes <- m1 * 10 + m2
      if (minutes < 60) // _ _ is less than 60
    } yield {
      val cTimeInMinutes = 60 * hours + minutes
      // Floormod: https://stackoverflow.com/questions/30003811/in-scala-why-could-remainder-operator-return-a-negative-number
      val minsElapsed = Math.floorMod(cTimeInMinutes - sTimeInMinutes, 24 * 60)
      if (minsElapsed > 0 && minsElapsed < elapsed) {
        nextClosestTime = cTimeInMinutes
        elapsed = minsElapsed
      }
    }
    // for leading zeros https://stackoverflow.com/questions/8131291/how-to-convert-an-int-to-a-string-of-a-given-length-with-leading-zeros-to-align/8131682
    f"${nextClosestTime / 60}%02d:${nextClosestTime % 60}%02d"
  }
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
