object Solution extends App {
  def isWinner(
      codeList: List[List[String]],
      shoppingCart: List[String]
  ): Int = {
    val codeListLen = codeList.length
    if (codeList.isEmpty) return 1 // u won!!!
    if (codeList.flatten.length > shoppingCart.length) return 0 // :(

    val (i, j) = shoppingCart.foldLeft(0, 0) {
      case ((listIdx, wordIdx), cartItem) => {
        if (listIdx >= codeListLen) return 1
        val codeWord = codeList(listIdx)(wordIdx)
        if (cartItem == codeWord || codeWord == "anything") {
          if (wordIdx < codeList(listIdx).length - 1) {
            (listIdx, wordIdx + 1)
          } else {
            (listIdx + 1, 0) // reset wordIdx to 0, increment listIdx
          }
        } else (listIdx, 0) // reset the word index
      }
    }

    if (i == codeListLen) 1 else 0
  }

  println(
    isWinner(
      List(),
      List("apple", "apple", "apple", "banana")
    )
  )

  println(
    isWinner(
      List(List("apple", "apple"), List("banana", "anything", "banana")),
      List("orange", "apple", "apple", "banana", "orange", "banana")
    )
  )
  println(
    isWinner(
      List(List("apple", "apple"), List("banana", "anything", "banana")),
      List(
        "apple",
        "apple",
        "orange",
        "orange",
        "banana",
        "apple",
        "banana",
        "banana"
      )
    )
  )
  println(
    isWinner(
      List(List("apple", "apple"), List("banana", "anything", "banana")),
      List("banana", "orange", "banana", "apple", "apple")
    )
  )
  println(
    isWinner(
      List(List("apple", "apple"), List("banana", "anything", "banana")),
      List("apple", "banana", "apple", "banana", "orange", "banana")
    )
  )
  println(
    isWinner(
      List(List("apple", "apple"), List("apple", "apple", "banana")),
      List("apple", "apple", "apple", "banana")
    )
  )
}
