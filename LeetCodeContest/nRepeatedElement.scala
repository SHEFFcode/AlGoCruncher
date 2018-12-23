object Solution {
    def repeatedNTimes(A: Array[Int]): Int = {
        val sortedArr = A.sorted
        if (sortedArr(sortedArr.size / 2 + 1) == sortedArr(sortedArr.size / 2)) sortedArr(sortedArr.size / 2)
        else sortedArr(sortedArr.size / 2 - 1)
    }
}