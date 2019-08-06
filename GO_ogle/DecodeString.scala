object Solution {
    def decodeString(s: String): String = {
        if (s.isEmpty) s
        else if (!Character.isDigit(s(0))) {
          val letterString = s.takeWhile(!Character.isDigit(_)) // we want to grab all non digits
          letterString + decodeString(s.drop(letterString.length)) // we will then append the digits here
        } else { // no other option here, since we cannot start with []
          val integerString = s.takeWhile(Character.isDigit(_)) // grab all the digits
          val repeat = findRepeatString(s.drop(integerString.length + 1), 1, "") // +1 because we want to drop the [
          decodeString(repeat) * integerString.toInt + decodeString(s.drop(repeat.length + integerString.length + 2)) //+2 because we want to exclide []
        }
    }

    private def findRepeatString(s: String, openBraceCount: Int, returnValue: String): String = {
      if (openBraceCount == 0) returnValue.dropRight(1) // drop ] from the right
      else {
        s.head match {
          case '[' => findRepeatString(s.tail, openBraceCount + 1, returnValue + '[')
          case ']' => findRepeatString(s.tail, openBraceCount - 1, returnValue + ']')
          case c => findRepeatString(s.tail, openBraceCount, returnValue + c)
        }
      }
    }
}