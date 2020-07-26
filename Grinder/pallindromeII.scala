object Solution extends App {
  def pallindrome(str: String): Boolean = {
    for (i <- 0 until str.length) {
      if (str(i) != str(str.length - 1 - i)) {
        return false
      }
    }
    true
  }

  println(pallindrome("a"))
}