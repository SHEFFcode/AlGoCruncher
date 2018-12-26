object Solution {
    def lengthOfLastWord(s: String): Int = {
        val strArr = s.trim.split(' ')
        strArr(strArr.length - 1).length
    }
}