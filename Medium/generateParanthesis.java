class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    if (n == 0) {
      return result;
    }
    StringBuilder paransSoFar = new StringBuilder();
    traverse(paransSoFar, n, 0, result);

    return result;
  }

  protected void traverse(StringBuilder paransSoFar, int numberOfParensAvailable, int numberOfUnclosedParens,
      List<String> result) {
    if (numberOfParensAvailable == 0 && numberOfUnclosedParens == 0) {
      result.add(paransSoFar.toString());
      return;
    }

    if (numberOfUnclosedParens > 0) {
      StringBuilder newParensSoFar = new StringBuilder(paransSoFar);
      newParensSoFar.append(')');
      traverse(newParensSoFar, numberOfParensAvailable, numberOfUnclosedParens - 1, result);
    }

    if (numberOfParensAvailable > 0) {
      StringBuilder newParensSoFar = new StringBuilder(paransSoFar);
      newParensSoFar.append('(');
      traverse(newParensSoFar, numberOfParensAvailable - 1, numberOfUnclosedParens + 1, result);
    }
  }
}