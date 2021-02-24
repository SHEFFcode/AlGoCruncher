import scala.collection.mutable.HashSet
object Solution extends App {

  val wizzards1 = Array(
    Array(1, 8, 6),
    Array(2, 3),
    Array(5, 2),
    Array(4, 6),
    Array(5, 8),
    Array(6, 9),
    Array(7, 9),
    Array(8, 9),
    Array(1),
    Array(1, 3)
  )

  private var gShortestPathArr = Array[Int]()
  private var gShortestPathLen = Int.MaxValue
  private val brain = HashSet[String]()

  private def findMinPath(
      wizzards: Array[Array[Int]],
      start: Int = 0,
      goal: Int = 9
  ) = {
    val cWizardFriends = wizzards(start)

    for (i <- cWizardFriends.indices) {
      val cShortestPathArr = Array(start)
      val cShortestPathLen = 0
      traverse(
        cWizardFriends(i),
        0,
        cShortestPathArr,
        cShortestPathLen,
        goal
      )
    }

    gShortestPathArr
  }

  private def traverse(
      cWizzard: Int,
      prevWizard: Int,
      shortestPathArr: Array[Int],
      shortestPathLen: Int,
      goal: Int
  ): Unit = {
    val cShortestPathArr = shortestPathArr :+ cWizzard
    val cShortestPathLen =
      (shortestPathLen + math.pow(cWizzard - prevWizard, 2)).toInt

    if (cWizzard == goal) {
      if (cShortestPathLen < gShortestPathLen) {
        gShortestPathLen = cShortestPathLen
        gShortestPathArr = cShortestPathArr.toArray
        return ()
      }
    }

    val cWizzardFriends = wizzards1(cWizzard)

    for (i <- cWizzardFriends.indices) {
      if (!brain.contains(s"$cWizzard,$i")) {
        brain += (s"$cWizzard,$i")
        traverse(
          cWizzardFriends(i),
          cWizzard,
          cShortestPathArr,
          cShortestPathLen,
          goal
        )
      }
    }
  }

  private def stringify(obj: Any): String = {
    scala.runtime.ScalaRunTime.stringOf(obj)
  }

  println(stringify(findMinPath(wizzards1, 0, 9))) // Array(0, 1, 2, 5, 6, 7, 9)
}
