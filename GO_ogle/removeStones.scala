import scala.collection.mutable.HashSet
import scala.collection.mutable.HashMap

object Solution {
  def removeStones(stones: Array[Array[Int]]): Int = {
    val (rows, cols, points) = stones.foldLeft((newMap, newMap, newSet)) {
      case ((rows, cols, points), Array(r, c)) => {
        rows(r) = rows.getOrElse(r, newList) :+ c
        cols(c) = cols.getOrElse(c, newList) :+ r
        points += point(r, c)

        (rows, cols, points)
      }
    }

    stones.foldLeft(stones.length) {
      case (countRemovable, Array(r, c)) => {
        if (points.contains(point(r, c))) {
          dfs(r, c, rows, cols, points)
          countRemovable - 1 // there will be 1 stone left per traversal
        } else countRemovable
      }
    }
  }

  private def dfs(
      r: Int,
      c: Int,
      rows: HashMap[Int, List[Int]],
      cols: HashMap[Int, List[Int]],
      points: HashSet[String]
  ): Unit = {
    points -= point(r, c)
    for (y <- rows(r)) {
      if (points.contains(point(r, y))) {
        dfs(r, y, rows, cols, points)
      }
    }

    for (x <- cols(c)) {
      if (points.contains(point(x, c))) {
        dfs(x, c, rows, cols, points)
      }
    }
  }

  private def newMap: HashMap[Int, List[Int]] = {
    HashMap[Int, List[Int]]()
  }

  private def newSet: HashSet[String] = {
    HashSet[String]()
  }

  private def newList: List[Int] = {
    List[Int]()
  }

  private def point(r: Int, c: Int): String = {
    s"$r:$c"
  }
}

/*
G:
O:
T:
S:

Notes:

Ex:
[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]] => 5

[0,0] <- 0 0
[0,1] <- 0 1
[1,0] <- 1 0
[1,2] <- 1 2
[2,1] <-  2 1
[2,2] <- 2 2

total = 6 - 1 = 5

{
  0:0,
  0:1,
  1:0,
  1:2,
  2:1
  2:2
}

{
  0 -> Array(Array(0, 0), Array(0, 1)),
  1 -> Array(Array(1, 0), Array(1, 2)),
  2 -> Array(Array(2, 1), Array(2, 2))
}

{
  0 -> Array(Array(0, 0), Array(0, 1)),
  1 -> Array(Array(1, 0), Array(1, 2)),
  2 -> Array(Array(2, 1), Array(2, 2))
}



Ex2:
Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3

[0,0]
[0,2]
[1,1]
[2,0]
[2,2]

row {
  0 -> 2
  1 -> 1
  2 -> 2
}

col {
  0 -> 2
  2 -> 2
  1 -> 1
}




Ex3:

[
  [3,2] 3 2
  [3,1] 3 1
  [4,4]
  [1,1] 1 1
  [0,2] 0 _
  [4,0] 4 _
]

{
  3:2
  3:1
  1:1
  0:2
  4:0
}


row {
  3 -> 0
  4 -> 2
  1 -> 1
  0 -> 1
}

col {
  2 -> 2
  1 -> 2
  4 -> 1
  0 -> 1
}

col {

}

{
  0 -> Array(Array(0, 2)),
  1 -> Array(Array(1, 1)),
  3 -> Array(Array(3, 2), Array(3, 1)),
  4 -> Array(Array(4, 4), Array(4, 0))
}

{
  0 -> Array(Array(4, 0)),
  1 -> Array(Array(3, 1), Array(1, 1)),
  2 -> Array(Array(3, 2), Array(0, 2)),
  4 -> Array(Array(4, 4))
}

 */
