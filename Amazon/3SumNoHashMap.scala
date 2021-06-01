import scala.collection.mutable.Set
object Solution {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if (nums.length < 3) return List()
    val set = Set[List[Int]]()
    scala.util.Sorting.quickSort(nums)
    for (i <- 0 until nums.length) {
      var (j, k) = (i + 1, nums.length - 1)
      while (j < k) {
        if (nums(i) + nums(j) + nums(k) < 0) {
          j += 1
        } else if (nums(i) + nums(j) + nums(k) > 0) {
          k -= 1
        } else {
          set += List(nums(i), nums(j), nums(k))
          j += 1
          k -= 1
        }
      }
    }
    set.toList
  }
}
