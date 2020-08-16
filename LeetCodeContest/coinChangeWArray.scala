object Solution extends App {
  def change(amount: Int, coins: Array[Int]): Int = {
    val sum = 1 +: Array.fill(amount)(
      0
    ) // this will create an array of size amount + 1, where first element at position 0 is 1

    coins.foreach(coin => {
      // if coin is bigger then amount, this will not run
      // if coin is smaller then or equal to amount, it will run
      (coin to amount).foreach(i => sum(i) += sum(i - coin))
      // this will then update the field at that index to be the number of ways at that index + number of ways we can get an amount smaller by this coin
      println(scala.runtime.ScalaRunTime.stringOf(sum))
    })
    sum.last
  }
}
