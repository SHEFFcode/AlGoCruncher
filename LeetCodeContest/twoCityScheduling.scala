object Solution {
  def twoCitySchedCost(costs: Array[Array[Int]]): Int = {
    val sortedCosts = costs.sortBy((a) => a(0) - a(1))
    val n = costs.size / 2

    sortedCosts.zipWithIndex.foldLeft(0) { (acc, itemWithIndex) =>
      {
        if (itemWithIndex._2 < n) {
          acc + itemWithIndex._1(0)
        } else {
          acc + itemWithIndex._1(1)
        }
      }
    }
  }
}
