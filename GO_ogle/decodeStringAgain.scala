object Solution {
  def decodeString(s: String): String = {
    if (s.isEmpty) s
    else if (!s(0).isDigit) {
      // we want to grab all non digits
      val letterString = s.takeWhile(!_.isDigit)
      letterString + decodeString(s.drop(letterString.length))
    } else { // no other option here, since we cannot start with []
      val count = s.takeWhile(_.isDigit) // grab all the digits
      // +1 because we want to drop the [
      val repeat = strToRepeat(s.drop(count.length + 1), 1, "")
      val cSegment = decodeString(repeat) * count.toInt
      //+2 because we want to exclide []
      val nextSegment = decodeString(s.drop(repeat.length + count.length + 2))
      cSegment + nextSegment
    }
  }

  private def strToRepeat(s: String, braceCnt: Int, cString: String): String = {
    if (braceCnt == 0) cString.dropRight(1) // drop ] from the right
    else {
      s.head match {
        case '[' => strToRepeat(s.tail, braceCnt + 1, cString + '[')
        case ']' => strToRepeat(s.tail, braceCnt - 1, cString + ']')
        case c   => strToRepeat(s.tail, braceCnt, cString + c)
      }
    }
  }
}

/*
G: s: String
O: decodedString: String
T: O(N)
S: O(n)

Notes:
  - k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times
  - Furthermore, you may assume that the original data does not contain any digits
    and that digits are only for those repeat numbers, k.
      ^ For example, there won't be input like 3a or 2[4].
  - Basically my idea is to find the number before the bracket and the ending one, and then repeat the string in a StringBuilder
  - Then we will just return the string
  - Opening bracket will always be a start of another recursive layer.

Ex:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

3[a]2[bc]



 */
