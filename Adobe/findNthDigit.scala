object Solution {
  def findNthDigit(n: Int): Int = {
    var digits = 1
    var base: Long = 9
    var input: Long = n
    var levelBound: Long = 0
    // find digit
    while (input > base * digits) {
      input -= base * digits
      base = base * 10
      levelBound = levelBound * 10 + 9
      digits += 1
    } //O(1)

    println(s"Deduced digit level $digits, last boundary number: $levelBound")
    var nthDigit = input % digits

    val number: Long = if (nthDigit == 0) {
      nthDigit = digits
      input / digits + levelBound
      //this will give you the number at this digit level e.g. 11-9 =2 /2 = 1 => this is the first number in 2-digit numbers, which is 10
    } else {
      input / digits + 1 + levelBound
    }

    println(s"Deduced number: $number, need $nthDigit th digit")

    s"$number" (nthDigit.toInt - 1) - '0'
    // ((number / math.pow(10, (digits - nthDigit)).toLong) % 10).toInt
  }
}
