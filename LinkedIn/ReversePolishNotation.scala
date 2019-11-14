import scala.collection.mutable.Stack

object Solution {
    def evalRPN(tokens: Array[String]): Int = {
        val stack: Stack[String] = Stack()
        tokens.foreach(token => {
            token match {
                case "+" | "-" | "*" | "/" => {
                    val result = doOp(stack.pop().toInt, stack.pop().toInt, token)
                    stack.push(s"$result")
                }
                case t: String => stack.push(t)
            }
        })

        stack.pop().toInt
    }

    private def doOp(second: Int, first: Int, op: String): Int = {
        op match {
            case "+" => first + second
            case "-" => first - second
            case "*" => first * second
            case "/" => first / second
        }
    }
}

/*
    Input: ["2", "1", "+", "3", "*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9

    [2, 1]

    second arr.pop()
    first arr.pop()
    result = first + second
    arr.push(result)

    [3, 3]

    second arr.pop
    first arr.pop
    result = first * second
    arr.push(result)

    return arr.pop()
*/