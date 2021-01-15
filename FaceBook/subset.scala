import scala.collection.mutable.ArrayBuffer

object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] =
    nums.foldLeft(List(List.empty[Int])) {
      case (res, cNum) => res ++ res.map(_ :+ cNum)
    }
}
