object Solution {
  def majorityElement(nums: Array[Int]): List[Int] = {
    val res = nums.foldLeft(Option.empty[Int], Option.empty[Int], 0, 0) {
      case (brain, n) => {
        val (cnd1, cnd2, cnt1, cnt2) = brain
        if (cnd1.nonEmpty && cnd1.get == n) brain.copy(_3 = cnt1 + 1)
        else if (cnd2.nonEmpty && cnd2.get == n) brain.copy(_4 = cnt2 + 1)
        else if (cnt1 == 0) brain.copy(_1 = Some(n), _3 = cnt1 + 1)
        else if (cnt2 == 0) brain.copy(_2 = Some(n), _4 = cnt2 + 1)
        else brain.copy(_3 = cnt1 - 1, _4 = cnt2 - 1)
      }
    }

    val (candidate1, candidate2, _, _) = res

    val (cnt1, cnt2) = nums.foldLeft(0, 0) {
      case ((cnt1, cnt2), n) => {
        if (candidate1.nonEmpty && n == candidate1.get) (cnt1 + 1, cnt2)
        else if (candidate2.nonEmpty && n == candidate2.get) (cnt1, cnt2 + 1)
        else (cnt1, cnt2)
      }
    }

    val n = nums.length
    var result = List[Int]()

    if (cnt1 > n / 3) result ::= candidate1.get
    if (cnt2 > n / 3) result ::= candidate2.get

    result
  }
}

/*
G: nums: Array[Int]
O: allIntsGreaterThanNOver3Times: List[Int]
T: O(N)
S: O(1)

Notes:
  - : Could you solve the problem in linear time and in O(1) space?

Ex:

 */
