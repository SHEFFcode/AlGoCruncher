class Solution {

    private Set<String> validExpressions = new HashSet<>();

    private void generateValidResults(String s, int index, int leftCount, int rightCount, int leftRemainToDiscard,
            int rightRemainToDiscard, StringBuilder expression) {

        // If we reached the end of the string, just check if the resulting expression is
        // valid or not and also if we have removed the total number of left and right
        // parentheses that we should have removed.
        if (index == s.length()) {
            if (leftRemainToDiscard == 0 && rightRemainToDiscard == 0) {
                this.validExpressions.add(expression.toString());
            }

        } else {
            char character = s.charAt(index);
            int length = expression.length();

            // The discard case. Note that here we have our pruning condition.
            // We don't recurse if the remaining count for that parenthesis is == 0.
            if ((character == '(' && leftRemainToDiscard > 0) || (character == ')' && rightRemainToDiscard > 0)) {
                this.generateValidResults(s, index + 1, leftCount, rightCount, // we will always discard 1 character
                        leftRemainToDiscard - (character == '(' ? 1 : 0), // which will either be the left bracket, reducing its count to discard
                        rightRemainToDiscard - (character == ')' ? 1 : 0), expression); // or the right bracket, reducing its count to discard
            }

            expression.append(character);

            // Simply recurse one step further if the current character is not a parenthesis.
            if (character != '(' && character != ')') {

                this.generateValidResults(s, index + 1, leftCount, rightCount, leftRemainToDiscard,
                        rightRemainToDiscard, expression);

            } else if (character == '(') {

                // Consider an opening bracket.
                this.generateValidResults(s, index + 1, leftCount + 1, rightCount, leftRemainToDiscard,
                        rightRemainToDiscard, expression);

            } else if (rightCount < leftCount) {

                // Consider a closing bracket.
                this.generateValidResults(s, index + 1, leftCount, rightCount + 1, leftRemainToDiscard,
                        rightRemainToDiscard, expression);
            }

            // Delete for backtracking.
            expression.deleteCharAt(length);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int extraLeftBrackets = 0, extraRightBrackets = 0;

        // First, we find out the number of misplaced left and right parentheses.
        for (int i = 0; i < s.length(); i++) {

            // if we have an opening bracket, let's increment the left bracket extras
            if (s.charAt(i) == '(') {
                extraLeftBrackets++;
            } else if (s.charAt(i) == ')') {
                // If we don't have any more extra left brackets, we have found our first extra right bracket
                if (extraLeftBrackets == 0) {
                    extraRightBrackets++;
                } else {
                    // if we do have extra left brackets, so we will decrement that number
                    extraLeftBrackets--;
                }

            }
        }

        this.generateValidResults(s, 0, 0, 0, extraLeftBrackets, extraRightBrackets, new StringBuilder());

        return new ArrayList<>(this.validExpressions);
    }
}

/**
 *  Input: "()())()"
 Output: ["()()()", "(())()"]

 Step 1: Figure out how many total parenthesis and which ones need to be removed.
 Step 2: Before going into choose explore unchoose, look if a bracket can be 
         discarded based on count remaining, and if it's bigger then 0,
         discard the char and decrement count.
Step 3: When the count of mismatched bracket (left or right) that you have currently selected is 0,
        we will choose the char by appending it to the expression builder.
Step 4: 

if(character != BRACKET.LEFT || character != BRACKET.RIGHT) {
    // we have a non bracket character, let's move on to the next char by calling recursion with current expression
} else if (character == BRACKET.LEFT) {
    // we have a new possible bracket group, let's increment leftBracket count and move on keeping other vars the same
} else if (leftBracketCount > rightBracketCount) {
    // we can put a right bracket in here without violating constraints, so let's increment rightBRacketCount and 
    // move on keeping the other vars the same
}

Step 5: If at any time in the new recursion we have reached the end of the string && 
        we have leftRamain and rightRemain eq to 0, we have found a possible combination
        let's add it to the result

Step 6: Don't forget to unchoose
Step 7, return the ArrayList<String>(Set<string> expressions);

 */