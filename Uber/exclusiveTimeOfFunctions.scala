import scala.collection.mutable.Stack
object Solution {
  val ID = 0
  val STATE = 1
  val TS = 2
  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
    val prevLog = logs.head.split(":")
    var prevTS = prevLog(TS).toInt
    var cLogs = logs.tail

    val res = Array.ofDim[Int](n)
    val stack = Stack[Int](prevLog(ID).toInt)

    for (_ <- 1 until logs.size) {
      val cLog = cLogs.head.split(":")
      if (cLog(STATE) == "start") {
        if (!stack.isEmpty) {
          // stack.head will have the previous functions id
          // we will access it in the res array and increment its runtime
          res(stack.head) += cLog(TS).toInt - prevTS // increase funcs runtime
        }

        stack.push(cLog(ID).toInt) // push current function id to the stack
        prevTS = cLog(TS).toInt // update previousely seen TS (start or end)
      } else {
        res(stack.head) += cLog(TS).toInt - prevTS + 1 // update func runtime
        stack.pop() // remove it off the stack frame
        prevTS = cLog(TS).toInt + 1 // update previous TS whether start or end
      }
      cLogs = cLogs.tail // move on the the next logs segment
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
