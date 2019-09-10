import java.util.Deque;
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(-1);
        int longestValidParens = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop(); // collpase the parens with its pair, leaving the previous unfinished business
                             // at the top
                if (stack.isEmpty()) {
                    stack.push(i); // if we do not have anything in the queue, we will have nothing to compare, so
                                   // add current index for future comparisons
                } else {
                    longestValidParens = Math.max(longestValidParens, i - stack.peek()); // do the comparison
                }
            }
        }
        return longestValidParens;
    }
}

/**
 * 0 1 2 3 4 5 " ) ( ) ( ) ) " => 4 i [-1, 0, 5], this is array of size
 * params.length() + 1
 * 
 * 2 - 0 = 2 4 - 0 = 4
 * 
 * 
 * 0 1 2 3 4 5 6 7 8 9 10 11 ( ) ( ( ) ) ) ( ) ) ( ) i
 * 
 * [-1, 6, 9]
 * 
 * 
 * i - stack.top() = 2, 4 - 2 = 2, 5 - -1 = 6, 8 - 6 = 2, 11 - 9 = 2 max = 6
 */