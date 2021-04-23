import scala.collection.mutable.ListBuffer

object Playground extends App {
  val stack = new ListBuffer[Int]() ++ List(1, 2, 3)
  val anotherStack = new ListBuffer[Int]() ++ List(4, 5, 6)

  println(stack ++ anotherStack)
  println(stack += 2)
  println(stack.head)
  stack.remove(stack.size - 1)
  println(stack)

  stack ++= anotherStack
  println(stack)
  println(stack.count(_ == 2))

  println(s"diff is ${stack.diff(anotherStack)}")

  println(stack.dropWhile(_ < 4))
  println(stack.getClass())

  println(new ListBuffer[Int]().headOption)

  println(stack.indices)
  println(stack.isEmpty)

  println(stack.sortWith(_ > _))

  val anotherLB = new ListBuffer[Int]()
  2 +=: anotherLB
  3 +=: anotherLB
  println(anotherLB)
  println(anotherLB.head)
  println(anotherLB.remove(0))
  println(anotherLB)
}
