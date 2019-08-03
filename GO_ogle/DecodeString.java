class Solution {
    public String decodeString(String s) {
        String result =  decodeHelper(new StringBuilder(), s);
        return result;
    }

    private String decodeHelper(StringBuilder decodedString, String remainingToDecode) {
        for (int i = 0; i < remainingToDecode.length(); i++) {
            if (Character.isDigit(remainingToDecode.charAt(i))) {
                StringBuilder count = new StringBuilder(String.valueOf(remainingToDecode.charAt(i))); // instanciate with a char.
                i++; // increment i here to move on to the next character.
                while (Character.isDigit(remainingToDecode.charAt(i))) { // danger zone
                    count.append(remainingToDecode.charAt(i));
                    i++; // mitigate danger.
                } // we now have the actual length
                int repeat = Integer.parseInt(count.toString());
                for (int j = 0; j < repeat; j++) {
                    decodedString.append(decodeHelper(decodedString, remainingToDecode.substring(i)));
                }
            } else {
                decodedString.append(remainingToDecode.charAt(i));
            }
        }

        return decodedString.toString();
    }
}