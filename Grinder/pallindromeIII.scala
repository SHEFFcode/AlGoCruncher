object Solution extends App {
  def pallindrome(str: String): Boolean = {
    for ((char, i) <- str.zipWithIndex) {
      if (char != str(str.length - 1 - i)) {
        return false
      }
    }
    true
  }

  println(pallindrome("abbad"))
}