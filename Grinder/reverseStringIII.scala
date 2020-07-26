import scala.collection.mutable.ArrayBuffer 

object Solution extends App {
  def reverseString(str: String) = {
    "Hello".foldLeft("") { (reversedString, letter) => { 
      s"$letter$reversedString" 
    }}
  }

  println(reverseString("Hello"))
}