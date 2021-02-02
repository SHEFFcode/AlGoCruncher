import scala.collection.mutable.ListBuffer
object Solution {
  val ID = 0
  val STATE = 1
  val TS = 2
  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
    val res = Array.ofDim[Int](n)
    val log = logs.head.split(":")
    var cLogs = logs.tail
    val stack = ListBuffer[Int](log(ID).toInt)
    var prev = log(TS).toInt

    for (_ <- 1 until logs.size) {
      val cLog = cLogs.head.split(":")
      if (cLog(STATE) == "start") {
        if (!stack.isEmpty) {
          res(stack.last) += cLog(TS).toInt - prev
        }

        stack += cLog(ID).toInt // append to stack
        prev = cLog(TS).toInt
      } else {
        res(stack.last) += cLog(TS).toInt - prev + 1
        stack.remove(stack.size - 1)
        prev = cLog(TS).toInt + 1
      }
      cLogs = cLogs.tail
    }

    res
  }
}

/*
G: n: Int, logs: List[String]
O: exclusiveTimeOfFunction: Array[Int]
T: O(N)
S: O(N)

Notes:
  - logs[i] represents the ith log message
  - log is formatted as string "{function_id}:{"start" | "end"}:{timestamp}"
  - "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3
  - "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2
  -  exclusive time is the sum of execution times for all function calls in the program
  -  For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.
  - Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.

Ex:

 */
