object Solution extends App {
  def pyramid(nSteps: Int) = {
    (1 to nSteps * 2 by 2).foreach(n => {
      val middle = "#" * n
      val padding = " " * (math.floor((nSteps * 2 - n) / 2.toFloat).toInt)
      println(padding + middle + padding)
    })
  }

  pyramid(5)
}
