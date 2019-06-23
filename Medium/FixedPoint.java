class Solution {
  public int fixedPoint(int[] A) {
    return binarySearch(0, A.length - 1, A);
  }

  private int binarySearch(int start, int end, int[] A) {
    int mid = start + (end - start) / 2;
    if (start > end) {
      return -1;
    } else if (A[mid] == mid) {
      return mid;
    } else if (A[mid] > mid) {
      return binarySearch(start, mid - 1, A);
    } else {
      return binarySearch(mid + 1, end, A);
    }
  }
}