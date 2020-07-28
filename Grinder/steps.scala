object Solution extends App {
  def steps(nSteps: Int) = {
    (1 to nSteps).foreach(n => {
      println(("#" * n) + (" " * (nSteps - n)))
    })
  }

  println(steps(3))
}

/**
  * steps(2) =>
  * "#" ,
  * "##"
  *
  * steps(3) =>
  * "#  ",
  * "## ",
  * "###"
  */
