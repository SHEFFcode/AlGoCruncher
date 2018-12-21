object Solution {
    def majorityElement(nums: Array[Int]): Int = {
        val sortedNums = nums.sorted
        sortedNums(sortedNums.length / 2)
    }
}