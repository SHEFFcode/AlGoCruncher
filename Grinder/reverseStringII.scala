object Solution extends App {
  def reverseString(str: String) = {
    (for(i <- str.length - 1 to 0 by -1) yield str(i)).mkString
  }

  println(s"Hello ${reverseString("Hello")}")
}