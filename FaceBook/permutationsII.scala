object Solution extends App {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    permute(nums.toList)
  }

  private def permute(nums: List[Int]): List[List[Int]] = {
    nums match {
      case List() => List(List())
      case _ =>
        for {
          x <- nums.distinct
          perm <- permute(removeElem(nums, x))
        } yield x :: perm
    }
  }

  private def removeElem(nums: List[Int], n: Int): List[Int] = {
    nums match {
      case List() => List()
      case (x :: xs) =>
        if (x == n) xs
        else x :: removeElem(xs, n)
    }
  }

  println(permuteUnique(Array(1, 1, 2)))
}

/*
G: nums: List[Int]
O: allUniquePermutations: List[List[Int]]
T: ???
S: ???

Notes:

Ex:

 */
