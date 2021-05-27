object Solution {
  def suggestedProducts(
      products: Array[String],
      searchWord: String
  ): List[List[String]] = {
    val lCaseSearchWord = searchWord.toLowerCase
    var lCaseSortedProducts = products.sorted.map(_.toLowerCase)

    lCaseSearchWord
      .foldLeft(List[List[String]](), "", lCaseSortedProducts) {
        case ((buf, stringSoFar, products), char) => {
          val prefix = (stringSoFar + char)
          val productsRemain = products.filter(_.take(prefix.length) == prefix)
          val suggestions = productsRemain.take(3).toList
          (buf :+ suggestions, prefix, productsRemain)
        }
      }
      ._1
  }
}
