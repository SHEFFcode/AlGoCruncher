import java.time.{LocalDate}
import java.time.format.DateTimeFormatter

/**
  * User class that accepts a list of strings
  * representing dates of user's logins
  *
  * @param logins
  */
case class User(logins: List[String] = List()) {
  def printStamps() = println(scala.runtime.ScalaRunTime.stringOf(logins))
}

object Solution extends App {
  private val DATE_FORMAT =
    "yyyy-M-d" // this pattern will handle both 1 and 2 digit month and day
  private val LOOK_BACK = 27 // defined by the question
  private val MIN_LOGINS = 5 // defined by the question

  /**
    * Function that takes in a User and returns a boolean
    * true if a user has 5 or more logins in the last 27 days
    * false if a user has 0 - 4 logins in the last 27 days
    * @param user
    * @return boolean
    */
  def checkUser(user: User): Boolean = {
    val userLogins = user.logins
    val validLogins = keepValidLogins(userLogins) // will ignore invalid inputs
    val loginsAsDateTime = validLogins.map(timeStamp =>
      LocalDate.parse(timeStamp, DateTimeFormatter.ofPattern(DATE_FORMAT))
    )
    val timeStampsWithinLookBackPeriod =
      loginsAsDateTime.filter(_.isAfter(LocalDate.now().minusDays(LOOK_BACK)))

    timeStampsWithinLookBackPeriod.length >= MIN_LOGINS
  }

  /*
    Function that will remove invalid input and only keep valid input
   */
  private def keepValidLogins(logins: List[String]): List[String] = {
    // fold left over the logins, and append them to a List of strings
    // if they are valid inputs
    logins.foldLeft(List[String]()) {
      case (list, login) => {
        if (login.count(_ == '-') == 2) { // valid login must have 2 dashes
          val Array(year, month, day) = login.split("-") // destructuring
          if (isNumber(year) && isNumber(month) && isNumber(day)) {
            list :+ login
          } else list
        } else list
      }
    }
  }

  // Determines if all chars in string are numeric
  // if so we know the whole string is numeric
  private def isNumber(str: String): Boolean = {
    str.forall(Character.isDigit)
  }

  /*
    Test runner function
   */
  def runTests() = {
    val testResults = List(
      emptyUserReturnsFalse(),
      userWithFiveReturnsTrue(),
      userWithSixReturnsTrue(),
      userWithFourOfSixReturnsFalse(),
      userWithFiveSingleDigitReturnsTrue(),
      userWithFiveSingleDigitAndOneWeirdFormatReturnsTrue(),
      userWithThreeReturnsFalse()
    )
    testResults.forall(_ == true)
  }

  /*
    User without any logins at all
   */
  private def emptyUserReturnsFalse(): Boolean = {
    val emptyUser = User()
    val result = checkUser(emptyUser)
    result == false
  }

  /*
    Five logins within 27 days of our current date (6.21.2021)
   */
  private def userWithFiveReturnsTrue(): Boolean = {
    val userWithFive = User(
      List("2021-05-29", "2021-05-28", "2021-05-27", "2021-05-26", "2021-05-30")
    )
    val result = checkUser(userWithFive)
    result == true
  }

  /*
    Six logins should return true as well
   */
  private def userWithSixReturnsTrue(): Boolean = {
    val userWithSix = User(
      List(
        "2021-05-29",
        "2021-05-28",
        "2021-05-27",
        "2021-05-26",
        "2021-05-30",
        "2021-05-31"
      )
    )
    val result = checkUser(userWithSix)
    result == true
  }

  /*
    User with 4 valid logins of 6 should return false
   */
  private def userWithFourOfSixReturnsFalse(): Boolean = {
    val userWithFour = User(
      List(
        "2021-04-29",
        "2021-04-28",
        "2021-05-27",
        "2021-05-26",
        "2021-05-30",
        "2021-05-31"
      )
    )
    val result = checkUser(userWithFour)
    result == false
  }

  /*
    User with five dates that include single digit days or months or both
    Should return true as well
   */
  private def userWithFiveSingleDigitReturnsTrue(): Boolean = {
    val userWithFive = User(
      List("2021-5-29", "2021-5-28", "2021-5-27", "2021-5-26", "2021-6-1")
    )
    val result = checkUser(userWithFive)
    result == true
  }

  /*
    invalid input should be ignored, just an assumption, there are other ways to handle this
   */
  private def userWithFiveSingleDigitAndOneWeirdFormatReturnsTrue(): Boolean = {
    val userWithFive = User(
      List(
        "2021-5-29",
        "2021-5-28",
        "2021-5-27",
        "2021-5-26",
        "2021-6-1",
        "hello" // let's supply an invalid input, and have it be ignored
      )
    )
    val result = checkUser(userWithFive)
    result == true
  }

  /*
    Three logins should also return false
   */
  private def userWithThreeReturnsFalse(): Boolean = {
    val userWithThree = User(List("2021-05-26", "2021-05-30", "2021-05-31"))
    val result = checkUser(userWithThree)
    result == false
  }

  println(
    checkUser(
      User(
        List(
          "2021-05-29",
          "2021-05-28",
          "2021-05-27",
          "2021-05-26",
          "2021-05-30"
        )
      )
    )
  )
  println(runTests())
}
