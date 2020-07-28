object Solution extends App {
  def fizzBuzz(num: Int) = {
    (1 to num).foreach((n: Int) => {
      if (n % 3 == 0) println("fizz")
      else if (n % 5 == 0) println ("buzz")
      else println(n)
    })
  }

  fizzBuzz(15)
}