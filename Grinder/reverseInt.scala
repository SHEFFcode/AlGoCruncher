object Solution extends App {
  def reverseInt(num: Int): Int = {
    if (num < 0) {
      s"${Math.abs(num)}".reverse.toInt * -1
    } else {
      s"$num".reverse.toInt
    }
  }

  println(reverseInt(-556))
}