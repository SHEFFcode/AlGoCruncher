import scala.collection.mutable
object Solution extends App {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.groupBy(_.sorted).values.map(_.toList).toList
  }
}

/*
object Solution extends App {

    def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val brain = mutable.HashMap[String, List[String]]()
    strs.foldLeft(brain) { (acc, str) =>
      {
        val key = str.sorted
        if (brain.contains(key)) {
          brain(key) = brain(key) :+ str
        } else {
          brain(key) = List[String](str)
        }
        brain
      }
    }

    brain.values.toList
  }

  println(groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")))
}
 */

/*
G: strings: Array[String]
O: groupedAnagrams: List[List[String]]
T: O(Nk) where k is the average length of each word
S: O(N)

Note:
 * We can check for anagrams into correct words by sorting the letters

Ex:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

["eat","tea","tan","ate","nat","bat"]

{
  "eat" -> ["ate","eat","tea"],
  "bat" -> ["bat"],
  "nat" -> ["nat","tan"]
}

[
  ["ate","eat","tea"],
  ["bat"],
  ["nat","tan"]
]
 */
