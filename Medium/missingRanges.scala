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
        if (nums(nums.length - 1) != upper) {
          val newTo = if (nums(nums.length - 1) == Integer.MAX_VALUE) nums(nums.length - 1) else nums(nums.length - 1) + 1
          addRange(nums(nums.length - 1), newTo, missingRanges)
        } 
        
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

/*
  Correct Solution
 */

 object Solution {
    def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[String] = {
      val missingRanges = new StringBuilder

      def recurse(nums: Array[Int], lower: Int, upper: Int, sb: StringBuilder, index: Int): StringBuilder = {
        val num = nums(index)
        if (lower < num - 1) sb ++= s"$lower->${num - 1},"
        else if (lower == num - 1) sb ++= s"$lower,"
        else if (num == Integer.MAX_VALUE) return sb
        else if (index == nums.length - 1) {
          if (lower < upper) sb ++= s"$lower->$upper"
          if (lower == upper) sb ++= s"$lower"
          return sb
        }
        recurse(nums, num + 1, upper, sb, index + 1)
      }

      recurse(nums, lower, upper, missingRanges, 0)
      if (missingRanges.nonEmpty) missingRanges.toString.split(',').toList else List()
    }
  }

  /*
  Another attempt, this needs a fix where we will not add to num before recursion, but will add to it after recursion and after check if its in bounds
  */

   object Solution {
    def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[String] = {
      val missingRanges = new StringBuilder

      def recurse(nums: Array[Int], lower: Int, upper: Int, sb: StringBuilder, index: Int): StringBuilder = {
        if (lower == Integer.MAX_VALUE) return sb
          if (index == nums.length) {
              println(lower, upper)
              if (lower < upper) sb ++= s"$lower->$upper,"
              if (lower == upper) sb ++= s"$lower,"
              return sb
          }
          val num = nums(index)
          if (num == Integer.MIN_VALUE) recurse(nums, num, upper, sb, index + 1)
          
          if (lower < num - 1) sb ++= s"$lower->${num - 1},"
          if (lower == num - 1) sb ++= s"$lower,"
          if (num == Integer.MAX_VALUE) return sb
          
          recurse(nums, num, upper, sb, index + 1)
      }

      recurse(nums, lower, upper, missingRanges, 0)
      if (missingRanges.nonEmpty) missingRanges.toString.split(',').toList else List()
    }
  }