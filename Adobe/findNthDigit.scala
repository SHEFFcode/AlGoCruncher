object Solution {
  def findNthDigit(n: Int): Int = {
    var digitLvl = 1 // 1 for 0 -> 9, 2 for 9 -> 99 etc
    var base: Long = 9 // base starts at 9, used 4 count
    var overLvlBound: Long = n
    var levelBound: Long = 0 // the 9, 99 from above
    // find digit
    while (overLvlBound > base * digitLvl) {
      overLvlBound -= base * digitLvl // 9, 90, 900 etc
      base = base * 10 // go up by 10, so 9, 99, 999 etc
      levelBound = levelBound * 10 + 9 // see above
      digitLvl += 1
    } //O(1)

    println(s"Deduced digit level $digitLvl, last boundary number: $levelBound")
    var nthDigit = // since remainder of 0 means we are exactly divide into n segs
      if (overLvlBound % digitLvl == 0) digitLvl else overLvlBound % digitLvl

    val number: Long = if (nthDigit == 0) {
      overLvlBound / digitLvl + levelBound
      //this will give you the number at this digit level e.g. 11-9 =2 / 2 = 1 => this is the first number in 2-digit numbers, which is 10
    } else {
      overLvlBound / digitLvl + 1 + levelBound
    }

    println(s"Deduced number: $number, need $nthDigit th digit")

    s"$number" (nthDigit.toInt - 1) - '0'
    // ((number / math.pow(10, (digits - nthDigit)).toLong) % 10).toInt
  }
}
