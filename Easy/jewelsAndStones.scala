object Solution {
    def numJewelsInStones(J: String, S: String): Int = {
        S.count(s => J.contains(s))
    }
}