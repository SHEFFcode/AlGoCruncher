import scala.collection.mutable
object Solution extends App {
  def fib(n: Int, brain: mutable.HashMap[Int, Int]): Int = {
    if (n == 0) 0
    else if (n == 1) 1
    else if (brain.contains(n)) brain(n)
    else fib(n - 1, brain) + fib(n - 2, brain)
  }

  println(fib(8, new mutable.HashMap()))
}
