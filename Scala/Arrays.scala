object Playground extends App {
  def pretty(array: AnyRef): String = scala.runtime.ScalaRunTime.stringOf(array)

  val arr = Array[Int]()
  val newArr = arr ++ (1 :: 2 :: 3 :: Nil)

  println(scala.runtime.ScalaRunTime.stringOf(newArr))
  println(newArr.containsSlice(List(1, 3)))
  println(newArr.exists(_ == 2))

  println(newArr.groupBy(_ > 2))

  val twoDArray = Array(Array(1, 2, 3), Array(4, 5, 6))

  println(pretty(twoDArray.flatten))
}
