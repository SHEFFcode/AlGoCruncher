class Solution {
    public String decodeString(String s) {
        StringBuilder decoded = new StringBuilder();
        decodeHelper(s, decoded, 0); // we want to start at 0

        return decoded.toString();
    }

    private int decodeHelper(String s, StringBuilder decoded, int i) {
        for (; i < s.length(); i++) {
            char cChar = s.charAt(i);
            if (Character.isDigit(cChar)) {
                StringBuilder counterString = new StringBuilder(String.valueOf(cChar));
                while (Character.isDigit(cChar = s.charAt(i + 1))) {
                    counterString.append(cChar);
                    i++;
                }
                int counter = Integer.parseInt(counterString.toString());
                i += 2; // because we want to skip the [ character.
                StringBuilder subsequent = new StringBuilder();
                i = decodeHelper(s, subsequent, i); // we need to know how many letters we processed.
                for (int c = 0; c < counter; c++) {
                    decoded.append(subsequent);
                }
            } else if (s.charAt(i) == ']') {
                break;
            } else {
                decoded.append(s.charAt(i));
            }
        }

        return i;
    }
}