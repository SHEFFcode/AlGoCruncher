abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  // higher-order functions
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

  // hofs
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip:(A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object EmptyList[Nothing](head: Nothing) extends MyList {
  def head: Nothing = Nothing
  def tail: Nothing = Nothing
  def isEmpty: Boolean = true
  def add[B >: A](element: B): MyList[B] = FullList(element)

  // higher-order functions
  def map[B](transformer: A => B): MyList[B] = EmptyList
  def flatMap[B](transformer: A => MyList[B]): EmptyList = EmptyList
  def filter(predicate: A => Boolean): MyList[A] = EmptyList

  // hofs
  def foreach(f: A => Unit): Unit = ()
  def sort(compare: (A, A) => Int): MyList[A] = EmptyList
  def zipWith[B, C](list: MyList[B], zip:(A, B) => C): MyList[C] = list
  def fold[B](start: B)(operator: (B, A) => B): B = start
}

class FullList[A](head: A, tail: FullList[A]) extends MyList {
  def head: A = head
  def tail: MyList[A] = tail
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = FullList(element, tail.add(head))
  def printElements: String = println(head) + printElements(tail)
  
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  // higher-order functions
  def map[B](transformer: A => B): MyList[B] = FullList(transformer(head), transformer(tail))
  def flatMap[B](transformer: A => MyList[B]): MyList[B] = transformer(head) ++ transformer(tail)
  def filter(predicate: A => Boolean): MyList[A] = 
    if (predicate(head)) MyList(head)
    else MyList(EmptyList, tail.filter(predicate))

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B] = FullList(list.head, list.tail) 

  // hofs
  def foreach(f: A => Unit): Unit = f(head) + f(tail)
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip:(A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}