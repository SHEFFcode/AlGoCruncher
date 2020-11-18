object Solution extends App {
  def canJump(nums: Array[Int]): Boolean = {
    def jumpExplorer(nums: Array[Int], idx: Int, longest: Int): Boolean = {
      if (idx > longest)
        return false // we want to break here if i is ever bigger then longest, since we got to a point we could not have reached. like this[3,2,1,0,4]
      if (idx >= nums.length - 1) return true
      val furthestICanJumpFromHere = idx + nums(idx)
      val cLongest =
        furthestICanJumpFromHere max longest // we never reduce the longest we could have jumped
      jumpExplorer(nums, idx + 1, cLongest)
    }
    jumpExplorer(nums, 0, 0)
  }

  println(canJump(Array(2, 3, 1, 1, 4)))
}

/*
G: nums: Array[Int]
O: ableToReachEnd: Boolean
T: O(N)
S: O(N)

Notes:
  - Array contains non negative integers
  - You are initially in the first index
  - Determine if you can reach the end
  - Each item represents max jump length
  - You have to choose that first index
  - Let's also be greedy, as soon as we reach once, return
  - Seems to be exhaustive search, so:
    ^ Choose
    ^ Explore
    ^ UnChoose

Ex:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

2 3 1 1 4
        i
 */
