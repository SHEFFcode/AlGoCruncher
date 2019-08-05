object Solution {
  def maxProduct(nums: Array[Int]): Int = {
    if (nums.length < 2) return nums(0)

    // I believe we need to skip the first rout of fold left somehow here
    val maxMinProd = nums.foldLeft((nums(0), nums(0), nums(0)))((accumulator, current) => {
      val maxPositive = accumulator._1
      val maxNegative = accumulator._2
      val maxProd = accumulator._3

      val newMaxPositive = math.max(math.max(current, maxPositive * current), maxNegative * current)
      val newMaxNegative = math.min(math.min(current, maxNegative * current), maxPositive * current)
      val newMaxProd = math.max(newMaxPositive, maxProd)
      (newMaxPositive, newMaxNegative, newMaxProd)
    })

    maxMinProd._3
  }
}