val result = for {
  a <- List(1, 2, 3)
  b <- List(3, 4, 5)
} yield a * b

val anotherResult = List(1, 2, 3).flatMap(itemFromList1 => List(3, 4, 5).map(itemFromList2 => itemFromList1 * itemFromList2))

println(result)

println(anotherResult)