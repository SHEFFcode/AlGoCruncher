import java.time.{LocalDate}
import java.time.format.DateTimeFormatter

case class User(logins: List[String] = List()) {
  def printStamps() = println(scala.runtime.ScalaRunTime.stringOf(logins))
}

object Solution extends App {
  private val DATE_FORMAT = "yyyy-MM-dd"
  private val LOOK_BACK = 27
  private val MIN_LOGINS = 5
  def checkUser(user: User): Boolean = {
    val userLogins = user.logins
    val loginsAsDateTime = userLogins.map(timeStamp =>
      LocalDate.parse(timeStamp, DateTimeFormatter.ofPattern(DATE_FORMAT))
    )
    val filteredTimeStamps =
      loginsAsDateTime.filter(_.isAfter(LocalDate.now().minusDays(LOOK_BACK)))

    filteredTimeStamps.length >= MIN_LOGINS
  }

  def runTests() = {
    val testResults = List(
      emptyUserReturnsFalse(),
      userWithFiveReturnsTrue()
    )
    testResults.forall(_ == true)
  }

  private def emptyUserReturnsFalse(): Boolean = {
    val emptyUser = User()
    val result = checkUser(emptyUser)
    result == false
  }

  private def userWithFiveReturnsTrue(): Boolean = {
    val userWithFive = User(
      List("2021-05-29", "2021-05-28", "2021-05-27", "2021-05-26", "2021-05-30")
    )
    val result = checkUser(userWithFive)
    result == true
  }

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
