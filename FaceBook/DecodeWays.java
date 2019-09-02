class Solution {
    public int numDecodings(String s) {

        Map<String, Integer> numDecodingsForSuffix = new HashMap<>();

        return decode(s, numDecodingsForSuffix, 0);
    }

    private int decode(String s, Map<String, Integer> numDecodingsForSuffix, int numDec) {
        if (s.length() < 2) {
            return numDec + s.length();
        } else if (s.length() == 2) {
            return numDec + Integer.parseInt(s.substring(0, 2)) < 27 ? 2 : 1;
        }

        // String suffix = s.substring(2);
        // if (numDecodingsForSuffix.containsKey(s)) {
        // return numDecodingsForSuffix.get(s);
        // }

        int additionalWays = decode(s.substring(2), numDecodingsForSuffix,
                numDec + Integer.parseInt(s.substring(0, 2)) < 27 ? 2 : 1);

        // numDecodingsForSuffix.put(suffix, additionalWays);

        return additionalWays + numDec;

    }
}