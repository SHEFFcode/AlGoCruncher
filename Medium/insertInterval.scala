object Solution {
  val START_TIME = 0
  val END_TIME = 1
  def insert(
      intervals: Array[Array[Int]],
      newInterval: Array[Int]
  ): Array[Array[Int]] = {
    for (idx <- 0 until intervals.length) {
      if (newInterval(START_TIME) <= intervals(idx)(END_TIME)) {
        if (newInterval(START_TIME) >= intervals(idx)(START_TIME)) {
          // if we find an insertion interval, let's do the insertion
          val smallerStart =
            math.min(intervals(idx)(START_TIME), newInterval(START_TIME))
          val biggestEnd =
            math.max(intervals(idx)(END_TIME), newInterval(END_TIME))
          intervals(idx)(START_TIME) = smallerStart // update start time
          intervals(idx)(END_TIME) = biggestEnd // update end time
          return mergeIntervals(intervals, idx)
        } else {
          // TODO: handle [[1,5]] || [0,0] case
          if (newInterval(END_TIME) > intervals(idx)(END_TIME)) {
            // Absorb
            intervals(idx)(START_TIME) = newInterval(START_TIME)
            intervals(idx)(END_TIME) = newInterval(END_TIME)
            return mergeIntervals(intervals, idx)
          }
          return mergeIntervals(newInterval +: intervals, idx)
        }
      }
    }
    // append the new interval
    intervals :+ newInterval
  }

  def mergeIntervals(
      intervals: Array[Array[Int]],
      idx: Int
  ): Array[Array[Int]] = {
    val currentInterval = intervals(idx)
    for (loc <- (idx + 1) until intervals.length) {
      val subsequentInterval = intervals(loc)
      if (shouldMergeIntervals(currentInterval, subsequentInterval)) {
        // make currentInterval(END_TIME) = subsequentInterval(END_TIME)
        intervals(idx)(END_TIME) = subsequentInterval(END_TIME)
        // delete the intervals between them
        return intervals.slice(0, idx + 1) ++ intervals.slice(
          loc + 1,
          intervals.length
        )
      }
    }
    intervals
  }

  def shouldMergeIntervals(
      currentInterval: Array[Int],
      subsequentInterval: Array[Int]
  ) = {
    if (subsequentInterval(START_TIME) == currentInterval(END_TIME)) {
      true
    } else if (
      subsequentInterval(START_TIME) < currentInterval(END_TIME)
      && subsequentInterval(END_TIME) >= currentInterval(END_TIME)
    ) {
      true
    } else {
      false
    }
  }
}

/*
  G: nonOverlappingIntervals: Array[Array[Int]], newInterval: Array[Int]
  O: newNonOverlappingIntervals: Array[Array[Int]]
  T: Any
  S: Any

  Notes:
    - Each interval is a tuple represented by Array[Int] of size 2
    - Intervals are sorted by end time in ascending order
    - New interval will also be a tuple represented by Array[Int] of size 2


Ex 1:
[[1,3],[6,9]], [2,5] => [[1,5],[6,9]]

[ [ 1 , 5 ] , [ 6 , 9 ] ]   [ 2, 5 ]
 *
                              #

Ex2:
[[1,2],[3,5],[6,7],[8,10],[12,16]] || [4,8] => [[1,2],[3,10],[12,16]]

[[1,2],[3,8],[6,7],[7,10],[12,16]]


Ex3:
[[1,5]] || [0,0] => [[0,0],[1,5]]

Ex4:

[[1,5]] || [0,6] => [[0,6],[1,5]]



Steps:
1) Find an interval where newInterval[START_TIME] <= existingInterval[END_TIME]
  - If we cannot find just an interval, just append the interval to the end of the array
  if (newInterval[START_TIME] >= existingInterval[START_TIME]) do below,
  If not, prepend or absorb
2) Modify the end time and start time of the existing interval as follows:
  - Make currentInterval[END_TIME] = newInterval[END_TIME]
3) Merge Intervals:
  - If the subsequentInterval(START_TIME) == currentInterval(END_TIME):
      # delete intervals between them
      # make currentInterval(END_TIME) = subsequentInterval(END_TIME)
  - If subsequentInterval(START_TIME) < currentInterval(END_TIME) && subsequentInterval(END_TIME) > currentInterval(END_TIME)
      # delete the intervals between them
      # make currentInterval(END_TIME) = subsequentInterval(END_TIME)
 */
