class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    if (n == 0) {
      return result;
    }
    traverse("", n, 0, result);

    return result;
  }

  protected void traverse(String paransSoFar, int numberOfParensAvailable, int numberOfUnclosedParens,
      List<String> result) {
    if (numberOfParensAvailable == 0 && numberOfUnclosedParens == 0) {
      result.add(paransSoFar);
      return;
    }

    if (numberOfUnclosedParens > 0) {
      traverse(paransSoFar + ')', numberOfParensAvailable, numberOfUnclosedParens - 1, result);
    }

    if (numberOfParensAvailable > 0) {
      traverse(paransSoFar + '(', numberOfParensAvailable - 1, numberOfUnclosedParens + 1, result);
    }
  }
}