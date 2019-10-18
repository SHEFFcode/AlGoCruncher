def partial(): Int => String = {
  case x: Int if x < 10 => "Hello less than 10"
  case _ => "I cannot handle that"
}

println(partial()(20))