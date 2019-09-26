class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int cNum = 0;
        int result = 0; // For the on-going result
        int sign = 1; // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {

                // Forming operand, since it could be more than one digit
                cNum = 10 * cNum + (int) (c - '0');

            } else if (c == '+') {

                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * cNum;

                // Save the recently encountered '+' sign
                sign = 1;

                // Reset operand
                cNum = 0;

            } else if (c == '-') {

                result += sign * cNum;
                sign = -1;
                cNum = 0;

            } else if (c == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (c == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * cNum;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                cNum = 0;
            }
        }
        return result + (sign * cNum);
    }
}

/**
 *  Input: "1 + 1"
    Output: 2


    1 + 1
    *

    // a bit of scala here
    arr[i] match {
        case '0-9' => if (!firstNum) firstNum = n else secondNum = n
        case '+' => result = firstNum + secondNum
        case '-' => result = firstNum - secondNum
        case '(' => recursion(string.substring(i))
        case ')' => result
    }

 */