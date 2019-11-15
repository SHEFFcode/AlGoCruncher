object Solution {
    def minDistance(word1: String, word2: String): Int = {
        val cache = Array.tabulate[Int](word1.length + 1, word2.length + 1){ (index1, index2) =>
            if (index1 == 0) index2
            else if (index2 == 0) index1
            else -1
        }

        levenshteinDistance(word1, 1, word2, 1, cache)

        cache(word1.length)(word2.length)
    }

    private def levenshteinDistance(
        word1: String,
        index1: Int,
        word2: String,
        index2: Int,
        cache: Array[Array[Int]]
    ): Unit = {
        if (index1 > word1.length || index2 > word2.length) return ()

        if (word1(zeroBasedIndex(index1)) == word2(zeroBasedIndex(index2))) {
            cache(index1)(index2) = cache(index1 - 1)(index2 - 1)
        } else {
            val delete = cache(index1)(index2 - 1)
            val insert = cache(index1 - 1)(index2)
            val sub = cache(index1 - 1)(index2 - 1)

            cache(index1)(index2) = 1 + Math.min(delete, Math.min(insert, sub))
        }

        levenshteinDistance(word1, index1 + 1, word2, index2, cache)
        levenshteinDistance(word1, index1, word2, index2 + 1, cache)
        levenshteinDistance(word1, index1 + 1, word2, index2 + 1, cache)
    }

    private def zeroBasedIndex(int: Int) = int - 1
}

/*
1. Insert a character
2. Delete a character
3. Replace a character

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')


  _ h o r s e
_ 0 1 2 3 4 5 
r 1 1 2 3 4 5
o 2 2 1 2 3 4
s 3 3 2 2 2 3


*/