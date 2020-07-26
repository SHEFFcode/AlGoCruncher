object Solution extends App {
  def pallindrome(str: String): Boolean = {
    str == str.reverse
  }

  println(pallindrome("abbad"))
}