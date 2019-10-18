val result = for {
  a <- List(1, 2, 3)
  b <- List(3, 4, 5)
} yield a * b

val anotherResult = List(1, 2, 3).flatMap(itemFromList1 => List(3, 4, 5).map(itemFromList2 => itemFromList1 * itemFromList2))

println(result)

println(anotherResult)

def fib(n: Int): Int = {
  n match {
    case n if n < 2 => n
    case _ => fib(n - 1) + fib(n - 2)
  }
}

println(fib(1))

case class Person(name: String)

val steve = Person("Peter")

steve match {
  case Person("Steve") => println("I am steve")
  case Person("Dave") => println("Dave")
  case _ => println("I don't know who I am")
}