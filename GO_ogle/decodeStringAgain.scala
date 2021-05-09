object Solution {
  def decodeString(s: String): String = {
    if (s.isEmpty) s
    else if (!s(0).isDigit) {
      // we want to grab all non digits
      val cSegment = s.takeWhile(!_.isDigit)
      cSegment + decodeString(s.drop(cSegment.length))
    } else { // no other option here, since we cannot start with []
      val xRepeat = s.takeWhile(_.isDigit) // grab all the digits
      // +1 because we want to drop the [
      val cSegRaw = pealLayer(s.drop(xRepeat.length + 1), 1, "")
      val cSegment = decodeString(cSegRaw) * xRepeat.toInt
      //+2 because we want to exclide []
      val nSegment = decodeString(s.drop(cSegRaw.length + xRepeat.length + 2))
      cSegment + nSegment
    }
  }

  private def pealLayer(s: String, braceCnt: Int, cString: String): String = {
    if (braceCnt == 0) cString.dropRight(1) // drop ] from the right, see ln 10
    else {
      s.head match {
        // we keep the inner layers by adding "[" and "]"
        case '[' => pealLayer(s.tail, braceCnt + 1, cString + '[')
        case ']' => pealLayer(s.tail, braceCnt - 1, cString + ']')
        case c   => pealLayer(s.tail, braceCnt, cString + c)
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
