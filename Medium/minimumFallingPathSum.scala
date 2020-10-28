import scala.collection.mutable
object Solution extends App {
  def minFallingPathSum(A: Array[Array[Int]]): Int = {
    val brain = mutable.HashMap[String, Int]()
    A(0).zipWithIndex.foldLeft(Int.MaxValue) { (gMin, itemIndex) =>
      {
        val (item, index) = itemIndex
        val arr = Array.fill(A.length)(0)
        arr(index) = item
        val cMin = traverse(A, 0, index, arr, brain)
        math.min(gMin, cMin)
      }
    }
  }

  def traverse(
      A: Array[Array[Int]],
      currentRow: Int,
      currentCol: Int,
      soFar: Array[Int],
      brain: mutable.HashMap[String, Int]
  ): Int = {
    val key = s"${soFar.mkString(",")}"
    if (brain.contains(key)) {
      println(s"taking from the brain ${key}")
      brain(key)
    } else if (
      currentRow < A.length && (currentCol > -1 && currentCol < A(0).length)
    ) {
      soFar(currentRow) = A(currentRow)(currentCol)
      val res = math.min(
        math.min(
          traverse(A, currentRow + 1, currentCol - 1, soFar.clone(), brain),
          traverse(A, currentRow + 1, currentCol, soFar.clone(), brain)
        ),
        traverse(A, currentRow + 1, currentCol + 1, soFar.clone(), brain)
      )
      // brain(key) = res
      res
    } else if (currentRow == A.length) {
      println(soFar.mkString(","))
      brain(key) = soFar.sum
      soFar.sum
    } else {
      Int.MaxValue
    }
  }

  println(
    minFallingPathSum(
      Array(Array(-80, -13, 22), Array(83, 94, -5), Array(73, -48, 61))
    )
  )
}
/*
G: squareArray: Array[Array[Int]]
O: minimumSum: Int
T: Any O(N) presumably
S: Any O(N) presumably

Notes:
 * Choose an element from each row
 * Next row's choice can be at most 1 col away from current row's col
 * This sounds a loot like choose, explore, un-choose exhaustive search
 * Usually these problems have repeating subproblems, so we will want a cache.

Ex1: [[1,2,3],[4,5,6],[7,8,9]] => 12

1 2 3
4 5 6
7 8 9

Steps:
 * First, let's just print all the possible routes and their sums
 * Second, we will cache the routes in some way
 * Third, profit!!!

 */
