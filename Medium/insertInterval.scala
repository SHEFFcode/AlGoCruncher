object Solution {
  val START_TIME = 0
  val END_TIME = 1
  def insert(
      intervals: Array[Array[Int]],
      newInterval: Array[Int]
  ): Array[Array[Int]] = {
    val (acc, last) =
      intervals.foldLeft((Array.empty[Array[Int]], newInterval)) {
        case ((result, cInterval), nxtInterval) =>
          if (cInterval(END_TIME) < nxtInterval(START_TIME)) {
            // if current interval ends before next one starts, no overlap, append cInterval, consider nextInterval later
            (result :+ cInterval, nxtInterval)
          } else if (cInterval(START_TIME) > nxtInterval(END_TIME)) {
            // if current interval starts after nextInterval ends, no overlap, append next interval, consider cInterval later
            (result :+ nxtInterval, cInterval)
          } else {
            // if there is an overlap, don't append anything, just merge the cInterval and nextInterval into a new super Interval
            (
              result,
              Array(
                Math
                  .min(nxtInterval(START_TIME), cInterval(START_TIME)),
                Math.max(nxtInterval(END_TIME), cInterval(END_TIME))
              )
            )
          }
      }
    // this just takes into account the last left over item
    acc :+ last
  }
}
