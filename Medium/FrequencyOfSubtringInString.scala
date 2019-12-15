
import scala.annotation.tailrec

/*
Input : man (pattern)
        dhimanman (string)
Output : 2

Input : nn (pattern)
        Banana (String)
Output : 0

Input : man (pattern)
        dhimanman (string)
Output : 2

Input : aa (pattern)
        aaaaa (String)
Output : 4
*/

object Solution {
  def frequencyOfSubtringInString(pattern: String, input: String) = {
    frequencyHelper(pattern, input, 0, 0)
  }
  
  @tailrec
  private def frequencyHelper(pattern: String, input: String, startIndex: Int, frequency: Int): Int = {
    if (startIndex >= input.length - (pattern.length - 1)) {
      frequency
    } else { 
      if (pattern.toLowerCase == input.substring(startIndex, startIndex + pattern.length).toLowerCase) {
        frequencyHelper(pattern, input, startIndex + 1, frequency + 1)
      } else {
        frequencyHelper(pattern, input, startIndex + 1, frequency)
      }
    }
  }
}

println(Solution.frequencyOfSubtringInString("man", "dhimanman"))
println(Solution.frequencyOfSubtringInString("aa", "aaaaa"))