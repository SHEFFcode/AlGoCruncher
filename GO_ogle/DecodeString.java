class Solution {
    public String decodeString(String s) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cChar = s.charAt(i);
            if (Character.isDigit(cChar)) {
                StringBuilder counterString = new StringBuilder(String.valueOf(cChar));
                while (Character.isDigit(cChar = s.charAt(i + 1))) {
                    counterString.append(cChar);
                    i++;
                }
                int counter = Integer.parseInt(counterString.toString());
                i += 2;
                String subsequent = decodeString(s.substring(i)); // we need to to be a tuple of how many chars
                                                                  // processed.
                for (int c = 0; c < counter; c++) {
                    decoded.append(subsequent);
                }

            } else if (s.charAt(i) == ']') {
                return decoded.toString();
            } else {
                decoded.append(s.charAt(i));
            }
        }

        return decoded.toString();
    }
}