import scala.collection.mutable.HashSet
import scala.collection.mutable.HashMap

object Solution {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    canBreak(s, 0, HashSet[String]() ++= wordDict, HashMap[Int, Boolean]())
  }

  private def canBreak(
      s: String,
      start: Int,
      words: HashSet[String],
      brain: HashMap[Int, Boolean]
  ): Boolean = {
    if (start == s.length) return true
    if (brain.contains(start)) return brain(start)

    for (end <- start + 1 to s.length) {
      val isValidWord = words.contains(s.substring(start, end))
      if (isValidWord && canBreak(s, end, words, brain)) {
        brain(start) = true
        return true // short circuit if we find a word
      }
    }
    brain(start) = false
    false
  }
}

/*
G: s: String, wordDic: List[String]
O: canSBeSegmented: Boolean
T: O(N^3) Because of the substring method
S: O(N) because of the cache

Notes:
  - Given a non-empty string s and a dictionary wordDict containing a list of non-empty words
  - s can be segmented into a space-separated sequence of one or more dictionary words.
  - The same word in the dictionary may be reused multiple times in the segmentation.
  - You may assume the dictionary does not contain duplicate words.

Ex:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Ex2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Ex3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false



 */
