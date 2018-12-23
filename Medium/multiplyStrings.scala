object Solution {
    def multiply(num1: String, num2: String): String = {

      def convertToInt(num: String): Int = {
        var accum = 0
        var multiplier = 10 * 
        for (c <- num) {
          println((c - '0') * multiplier)
          accum += (c - '0') * multiplier
        }
        accum
      }

      val number1 = convertToInt(num1)
      val number2 = convertToInt(num2)

      number1 * number2 + ""
    }
}

/**
Solution above integer overflows, so we gotta come up with a different solution that will not
*/

object Solution {
    def multiply(num1: String, num2: String): String = {
      val pos: Array[Int] = new Array[Int](num1.length + num2.length)

      for {
        i <- num1.length - 1 to 0 by -1
        j <- num2.length - 1 to 0 by -1
      } yield {
        val mul = (num1(i) - '0') * (num2(j) - '0')
        val p1 = i + j
        val p2 = i + j + 1
        val sum = mul + pos(p2)
        pos(p1) += sum / 10
        pos(p2) = sum % 10
      }
      pos.mkString.replaceFirst("^0+(?!$)", "")

      /**
      Alternative with string builder
      */
      // val sb = new StringBuilder
      // for (num <- pos) {
      //   if (sb.length != 0 || num != 0) {
      //     sb.append(num)
      //   }
      // }

      // if (sb.length == 0) {
      //   "0"
      // } else {
      //   sb.toString
      // }
    }
  }