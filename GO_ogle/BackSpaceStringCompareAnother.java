class Solution {
    public boolean backspaceCompare(String s, String t) {
        s = removeBackspace(s);
        t = removeBackspace(t);
        return s.equals(t);
    }

    private String removeBackspace(String s) {
        if (s == null || s.isEmpty())
            return s;
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int dels = 0;
        while (i >= 0) {
            char ch = s.charAt(i);
            if (ch == '#') {
                dels++;
            } else if (dels > 0) {
                dels--;
            } else {
                sb.append(ch);
            }
            i--;
        }
        return sb.toString();
    }
}