/*
  Length of the longest repeating substring

  Input : Banana (String)
          i j

  Output : 3
*/

object Solution {
  def longestRepeatingSubstring(input: String) = {
    longestRepeatHelper(input, 0, 1, 0)
  }
  
  private def longestRepeatHelper(input: String, i: Int, j: Int, longestSoFar: Int): Int = {
    if (i >= input.length - 1 || j >= input.length) {
      longestSoFar
    } else {
      if (input(i) == input(j)) {
        longestRepeatHelper(input, i + 1, j + 1, longestSoFar + 1)
      } else if (j < input.length - 1) {
        longestRepeatHelper(input, i, j + 1, longestSoFar)
      } else {
        longestRepeatHelper(input, i + 1, i + 2, longestSoFar)
      }
    }
  }
}

println(Solution.longestRepeatingSubstring("banana"))
println(Solution.longestRepeatingSubstring("aaaaa"))