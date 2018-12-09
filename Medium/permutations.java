class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> leftHalf = new ArrayList<>();
    List<Integer> rightHalf = new ArrayList<>();
    for (int num : nums) {
      rightHalf.add(num);
    }

    traverse(leftHalf, rightHalf, result);
    return result;
  }

  public List<List<Integer>> traverse(List<Integer> leftHalf, List<Integer> rightHalf, List<List<Integer>> result) {
    if (rightHalf.size() == 0) {
      return result;
    }

    if (rightHalf.size() == 1) {
      int item = rightHalf.remove(0);
      leftHalf.add(item);
      result.add(leftHalf);
      return result;
    }

    for (int i = 0; i < rightHalf.size(); i++) {
      int item = rightHalf.get(i);
      List<Integer> newLeftHalf = new ArrayList<>(leftHalf);
      List<Integer> newRightHalf = new ArrayList<>(rightHalf);
      newLeftHalf.add(item);
      newRightHalf.remove(i);
      traverse(newLeftHalf, newRightHalf, result);
    }

    return result;
  }
}