object Solution {
    def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[String] = {
        val missingRanges = new StringBuilder
        if (nums.isEmpty) {
            return addRange(lower - 1, upper + 1, missingRanges).split(',').toList
        }
        if (nums(0) != lower) {
            if (lower < 0) addRange(lower - 1, nums(0), missingRanges)
            else addRange(lower - 1, nums(0), missingRanges)
        } 
        for {
          i <- 0 to (nums.length - 2)
        } yield {
          val j = i + 1
          if ((nums(j) - nums(i)).abs != 1 && (nums(j) - nums(i)).abs != 0) {
            addRange(nums(i), nums(j), missingRanges)
          } 
        }
        if (nums(nums.length - 1) != upper) addRange(nums(nums.length - 1), upper + 1, missingRanges)
        
        if (!missingRanges.isEmpty) missingRanges.toString.split(',').toList else List()
    }

    def addRange(from: Int, to: Int, missingRanges: StringBuilder) = {
      if ((to - from).abs > 2) {
        missingRanges ++= s"${from + 1}->${to - 1},"
      } 
      else {
        missingRanges ++= s"${from + 1},"
      } 
    }
}