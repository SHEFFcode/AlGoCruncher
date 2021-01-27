import scala.collection.mutable.ListBuffer

object Solution {
  private type DoubleList = List[List[Int]]
  private type DoubleBuf = ListBuffer[List[Int]]
  private val HI = true
  private val LO = false
  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
    kSum(nums.sorted, target, 0, 4).toList // because 4 sum
  }

  private def kSum(nums: Array[Int], t: Int, strt: Int, k: Int): DoubleBuf = {
    val res = ListBuffer[List[Int]]()

    if (invalid(nums, strt, k, t)) return res
    if (k == 2) return twoSum(nums, t, strt) // we got down to 2 sum

    for (i <- strt until nums.length) {
      if (i == strt || nums(i - 1) != nums(i)) {
        // if we are the first number or we are not a duplicate
        for (setOfK <- kSum(nums, t - nums(i), i + 1, k - 1)) {
          val setWithNum = nums(i) +: setOfK
          res += setWithNum
        }
      }
    }

    res
  }

  private def twoSum(nums: Array[Int], target: Int, start: Int) = {
    val res = ListBuffer[List[Int]]()

    var lo = start
    var hi = nums.length - 1

    while (lo < hi) {
      val sum = nums(lo) + nums(hi)

      if (sum < target || isDup(lo, start, LO, nums)) lo += 1
      else if (sum > target || isDup(hi, start, HI, nums)) hi -= 1
      else {
        res += List(nums(lo), nums(hi))
        lo += 1
        hi -= 1
      }
    }
    res
  }

  def isDup(ptr: Int, strt: Int, pType: Boolean, nums: Array[Int]): Boolean = {
    pType match {
      case true  => (ptr < nums.length - 1 && nums(ptr) == nums(ptr + 1))
      case false => (ptr > strt && nums(ptr) == nums(ptr - 1))
    }
  }

  private def invalid(nums: Array[Int], strt: Int, k: Int, t: Int): Boolean = {
    strt == nums.length || // we've ran out the array
    nums(strt) * k > t || // 4 of the current numbers are > target
    t > nums(nums.length - 1) * k // 4 of the largest numbers < target
  }
}
