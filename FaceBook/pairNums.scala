// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object PairSums {

  def main(args: Array[String]) {
    // Call numberOfWays() with test cases here
    println(s"First solution: ${numberOfWays(Array(1, 5, 3, 3, 3), 6)}")

  }

  def numberOfWays(arr: Array[Int], k: Int): Int = {
    // Write your code here
    var numFreq = arr.groupBy(identity)
    var res = 0

    for ((key, value) <- numFreq) {
      val compliment = k - key
      val w = value.length // weight

      if (numFreq.contains(compliment)) {
        val addition = if (compliment != key) w else (w * (w - 1)) / 2
        numFreq -= key // remove key
        res += addition // update count
      }
    }

    res
  }
}

/*
1, 3, 3, 3, 5
 */
