import scala.collection.mutable.Queue

object Solution {
  val EMPTY = Int.MaxValue
  val GATE = 0
  val DIRECTIONS = List((0, -1), (0, 1), (-1, 0), (1, 0))
  def wallsAndGates(rooms: Array[Array[Int]]): Unit = {
    val (nRow, nCol) = (rooms.size, rooms(0).size)

    val queue = Queue[(Int, Int)]()
    for (r <- 0 until nRow) {
      for (c <- 0 until nCol) {
        if (rooms(r)(c) == GATE) queue.enqueue((r -> c))
      }
    }

    while (queue.nonEmpty) {
      val point = queue.dequeue
      val (cRow, cCol) = (point._1, point._2)
      for (direction <- DIRECTIONS) {
        val (nextRow, nextCol) = (cRow + direction._1, cCol + direction._2)
        if (
          nextRow >= 0 &&
          nextRow < nRow &&
          nextCol >= 0 &&
          nextCol < nCol &&
          rooms(nextRow)(nextCol) == EMPTY
        ) {
          rooms(nextRow)(nextCol) = rooms(cRow)(cCol) + 1
          queue.enqueue((nextRow -> nextCol))
        }
      }
    }
  }

}

/*
G: roms: Array[Array[Int]]
O: Unit
T: O(n*m)
S: O(n*m)

Notes:
  - m x n grid rooms
  - Initialized to one of three values:
    ^ -1  => a wall
    ^ 0   => a gate
    ^ INF => empty room
  - Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Ex:

 */
