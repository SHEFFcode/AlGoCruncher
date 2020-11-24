object Solution extends App {
  def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
    if (intervals.length < 2) return intervals.length
    var roomsRequired = 0
    var roomsInUse = 0
    val startTimes = intervals.map(_(0)).sorted
    val endTimes = intervals.map(_(1)).sorted
    var j = 0
    for (i <- 0 until startTimes.length) {
      roomsInUse += 1 // we will always being a meeting
      if (startTimes(i) >= endTimes(j)) {
        roomsInUse -= 1 // we will end a meeting here
        j += 1
      }
      roomsRequired = roomsRequired max roomsInUse
    }
    roomsRequired
  }

  // println(
  //   s"meetingsRequired: ${minMeetingRooms(Array(Array(0, 30), Array(5, 10), Array(15, 20)))}"
  // )
  // println(s"meetingsRequired: ${minMeetingRooms(Array(Array(7, 10)))}")
  // println(
  //   s"meetingsRequired: ${minMeetingRooms(Array(Array(2, 11), Array(6, 16), Array(11, 16)))}"
  // )
  // println(
  //   s"meetingsRequired: ${minMeetingRooms(Array(Array(1, 5), Array(8, 9), Array(8, 9)))}"
  // )
  println(
    s"meetingsRequired: ${minMeetingRooms(Array(Array(7, 10), Array(2, 4)))}"
  )
}

/*
G: intervals: Array[Array[Int]]
O: minMeetingRooms: Int
T: O n log(N)
S: O(n)

Notes:
  -

Ex:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2


[[0, 30],[5, 10],[15, 20]]

[0, 5, 15] => spin up a meeting room
          i
[10, 20, 30] => spin down a meeting room
      j

numRooms = 1
max = 2

if (i < j) spin up a room
else spin down a room

[5,10]  [15, 20], [0, 30]

Ex2:
Input: [[7,10],[2,4]]
Output: 1

[7,10], [2,4]

[2, 4], [7, 10]

Ex3:


[[1,5],[8,9],[8,9]] => 2



1, 8, 8
i
5, 9, 9
j
 */
