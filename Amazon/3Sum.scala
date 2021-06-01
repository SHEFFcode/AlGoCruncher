import scala.collection.mutable.HashMap
object Solution {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val srtdNums = nums.sorted
    val map = HashMap[Int, Int]()
    val res = HashSet(List[Int])

    srtdNums.zipWithIndex.foldLeft(map) {
      case (brain, (num, idx)) => map(-num) = idx // inverse to idx map
    }

    for {
      i <- 0 until srtdNums.length - 1 // leave space for last el
      j <- i + 1 until nums.length // exclude first el
    } yield {
      val total = srtdNums(i) + srtdNums(j)
      if (map.contains(total) && map(total) != i && map(total) != j) { // can't reuse
        result += List(srtdNums(i), srtdNums(j), -total)
      }
    }

    res.toList
  }
}
