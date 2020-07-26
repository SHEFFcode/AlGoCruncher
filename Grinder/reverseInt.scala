object Solution extends App {
  def reverseInt(num: Int): Int = {
    s"$num".reverse.toInt
  }

  println(reverseInt(556))
}