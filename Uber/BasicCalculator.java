class Solution {
    public int calculate(String s) {
        return calculateHelper(s, 0, '+', -1, -1);
    }

    private int calculateHelper(String s, int index, char magnitude, int firstNum, int secondNum) {
        if (index >= s.length()) {
            return 0; // we have reached the end
        }

        // we need to fast forward here
        while (index < s.length() && s.charAt(index) == ' ') {
            System.out.println("Skipping character " + s.charAt(index));
            index++;
        }

        char c = s.charAt(index);

        System.out.println("Character is " + c);

        int result = 0;

        if (Character.isDigit(c) == true) {
            StringBuilder numString = new StringBuilder();

            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                numString.append(s.charAt(index));
                index++;
            }

            System.out.println("Numstring is " + numString.toString());

            int num = Integer.parseInt(numString.toString()); // length will be zero if its not a digit
            int secondNumber = calculateHelper(s, index, magnitude, num, -1);
            System.out.println("Adding numbers  " + num + " and " + secondNumber);

            int calcSoFar = num + secondNumber;
            System.out.println("result so far is " + calcSoFar);
            return calcSoFar; // we need to get that second num
        } else if (c == '+') {
            // this is a no op
            int res = calculateHelper(s, index + 1, '+', firstNum, -1);
            System.out.println("result is " + res);
            return res;
        } else if (c == '-') {
            // this is a no op, update magnitude
            int res = -1 * calculateHelper(s, index + 1, '+', firstNum, -1);
            System.out.println("result is " + res);
            return res;
        } else if (c == '(') {
            // this is a new recursion
            return firstNum + calculateHelper(s, index + 1, magnitude, -1, -1); // new recursion with unknown first and second nums
        } else {
            return 0;
        }
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