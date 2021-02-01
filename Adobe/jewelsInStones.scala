object Solution {
  def numJewelsInStones(J: String, S: String): Int = {
    S.count(J.contains(_))
  }
}
