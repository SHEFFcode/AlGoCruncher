// Definition of Maybe, implement MaybeNot and Just
abstract class Maybe[+T] {
  def map[B](f: T => B): Maybe[B] // functor definition
  def flatMap[B](f: T => Maybe[B]): Maybe[B] // monad definition
  def filter(p: T => Boolean): Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {
  def map[B](f: Nothing => B): Maybe[B] = MaybeNot // functor definition
  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot // monad definition, both functor and monad always return same type
  def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T] {
  def map[B](f: T => B): Maybe[B] = Just(f(value)) // functor definition, will wrap function applied to value into context of functor Maybe
  def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value) // monad definition, since our Monad already adds monadic context, we don't have to wrap it
  def filter(p: T => Boolean): Maybe[T] = {
    if (p(value)) this // since we have only one value, we check predicate against that value, and either return the monad
    else MaybeNot // or we return empty object
  }
}

val just3 = Just(3)
println(just3)
println(just3.map(_ * 2))
println(just3.flatMap(x => Just(x % 2 == 0)))
println(just3.filter(_ % 2 == 0))