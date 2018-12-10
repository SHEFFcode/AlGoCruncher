class Solution {
  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList();
    StringBuilder stringSoFar = new StringBuilder();
    Map<Character, char[]> digitToLettersMap = new HashMap<>();
    buildPhoneMap(digitToLettersMap);
    traverse(result, digits, stringSoFar, digitToLettersMap);

    return result;
  }

  protected void traverse(List<String> result, String digits, StringBuilder stringSoFar,
      Map<Character, char[]> digitToLettersMap) {
    if (stringSoFar.length() == digits.length()) {
      result.add(stringSoFar.toString());
      return;
    }

    for (char letter : digitToLettersMap.get(digits.charAt(stringSoFar.length()))) { // length here will point to the
                                                                                     // next letter to
                                                                                     // use
                                                                                     // safe cause of case above
      stringSoFar.append(letter);
      traverse(result, digits, stringSoFar, digitToLettersMap);
      stringSoFar.deleteCharAt(stringSoFar.length() - 1); // remove the last character from the stringbuilder to
                                                          // backtrack.
    }
  }

  private void buildPhoneMap(Map<Character, char[]> map) {
    map.put('2', new char[] { 'a', 'b', 'c' });
    map.put('3', new char[] { 'd', 'e', 'f' });
    map.put('4', new char[] { 'g', 'h', 'i' });
    map.put('5', new char[] { 'j', 'k', 'l' });
    map.put('6', new char[] { 'm', 'n', 'o' });
    map.put('7', new char[] { 'p', 'q', 'r', 's' });
    map.put('8', new char[] { 't', 'u', 'v' });
    map.put('9', new char[] { 'w', 'x', 'y', 'z' });
  }
}

/**
 * Another way to do this
 */
class Solution {

  String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

  public List<String> letterCombinations(String digits) {
    // digits: 2-9
    // res: letter combinations
    List<String> res = new ArrayList<>();
    if (digits.length() == 0)
      return res;

    backtrack(res, "", digits, 0);
    return res;
  }

  private void backtrack(List<String> res, String cur, String digits, int pos) {
    if (cur.length() == digits.length()) {
      res.add(cur);
      return;
    }
    char c = digits.charAt(pos);
    String s = map[c - '0'];
    for (char ch : s.toCharArray()) {
      backtrack(res, cur + ch, digits, pos + 1);
    }

  }
}