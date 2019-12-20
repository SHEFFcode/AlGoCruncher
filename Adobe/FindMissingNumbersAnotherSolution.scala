object Solution {
    def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
        val array = new Array[Int](nums.length + 1)
        for (i <- nums.indices) {
            array(nums(i)) = 1
        }
        val result = (1 to nums.length).filter(array(_) == 0)

        result.toList
    }
}