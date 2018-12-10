class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    if (n == 0) {
      return result;
    }
    StringBuilder paransSoFar = new StringBuilder();

    return traverse(paransSoFar, n, 0);
  }

  protected List<String> traverse(StringBuilder paransSoFar, int numberOfParensAvailable, int numberOfUnclosedParens,
      List<String> result) {
    if (numberOfParensAvailable == 0) {
      while (numberOfUnclosedParens > 0) {
        paransSoFar.append(')');
        numberOfUnclosedParens--;
      }
      return result.add(paransSoFar.toString());
    } else if (numberOfUnclosedParens == 0) {
      return generateParenthesis(paransSoFar.append('('), numberOfParensAvailable--, numberOfUnclosedParens++);
    }

    return generateParenthesis(paransSoFar.append('('), numberOfParansAvailable--, numberOfUnclosedParens++)
        .add(generateParenthesis(paransSoFar.append(')'), numberOfParansAvailable, numberOfUnclosedParens--));
  }
}