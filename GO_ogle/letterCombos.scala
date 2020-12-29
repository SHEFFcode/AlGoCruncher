import scala.collection.immutable.HashMap

object Solution {
  private final type StringMap = HashMap[Char, String]
  private final type Strings = List[String]

  def letterCombinations(digits: String): List[String] = {
    if (digits.length == 0) return List()
    val phoneList = buildPhoneList()
    backTrack("", digits, phoneList, List[String]())
  }

  private def backTrack(
      cCombo: String,
      digits: String,
      phoneList: StringMap,
      res: Strings
  ): Strings = {
    if (digits.length == 0) res :+ cCombo
    else {
      val possibleLetters = phoneList(digits.head)
      possibleLetters.foldLeft(res) { (res, letter) =>
        backTrack(cCombo + letter, digits.tail, phoneList, res)
      }
    }
  }

  private def buildPhoneList(): StringMap = {
    HashMap(
      ('2' -> "abc"),
      ('3' -> "def"),
      ('4' -> "ghi"),
      ('5' -> "jkl"),
      ('6' -> "mno"),
      ('7' -> "pqrs"),
      ('8' -> "tuv"),
      ('9' -> "wxyz")
    )
  }
}

/*
G: digits: String
O: allCombos: List[String]
T: O(n4^n)
S: O(4^n)

Notes:

Ex:

 */
