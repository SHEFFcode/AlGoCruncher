object Solution {
    def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean = {
        val sum = nums.sum
        if (sum % k > 0) false
        else {
            val target = sum / k
            nums.sorted
            val row = nums.length - 1
            // since the array is sorted, if we see a number at the back that is bigger then target we are done
            if (nums(row) > target) false
            else {
                search(Array.ofDim[Int](k), row, nums, target)
            }
        }
    }

    private def search(groups: Array[Int], row: Int, nums: Array[Int], target: Int): Boolean = {
        if (row >= 0 && nums(row) == target) search(groups, row - 1, nums, target)
        else if (row < 0) true
        else {
            row = row - 1
            val cNum = nums(row)
            for {
                i <- 0 to groups.length
            } yield {
                if (groups(i) + cNum <= target) {
                    groups(i) += cNum
                    if (search(groups, row, nums, target)) return true
                    else {
                        groups(i) -= cNum
                    }
                }
                if (groups(i) == 0) return false
            }

            false
        }
    }
}

/*
    Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
                   
    Output: True
    Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

    The key here is to recognize that k is a huge help here. We need to find the sum of the array,
    and see if that sum is divisible by k. If not, the task is impossible.
*/