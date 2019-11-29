class BalancedParensInput {
    public static void main(String[] args) {
        String balancedString = balancedString("ab((cdef)");
        System.out.println(balancedString);
    }

    public static String balancedString(String input) {
        // First pass remove non matching left parens
        int openingBracesLeft = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                if (c == '(') {
                    openingBracesLeft++;
                    sb.append("" + c);
                } else if (c == ')') {
                    if (openingBracesLeft > 0) {
                        sb.append("" + c);
                        openingBracesLeft--;
                    }
                }
            } else {
                sb.append(c);
            }
        }
        // Second pass remove the non matching right parens
        String rightToLeft = sb.toString();
        sb = new StringBuilder();
        int closingBracesLeft = 0;
        for (int i = rightToLeft.length() - 1; i > -1; i--) {
            char c = rightToLeft.charAt(i);
            if (!Character.isAlphabetic(c)) {
                if (c == ')') {
                    closingBracesLeft++;
                    sb.append("" + c);
                } else if (c == '(') {
                    if (closingBracesLeft > 0) {
                        sb.append("" + c);
                        closingBracesLeft--;
                    }
                }
            } else {
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }
}

/**
 * ab((cdef) => ab(cdef)
 * 
 * 
 */