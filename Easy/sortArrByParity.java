class Solution {
  public int[] sortArrayByParityII(int[] A) {
    int lastOddIndex = A.length - 1;
    int lastEvenIndex = A.length - 2;
    for (int i = 0; i < A.length; i++) {
      if (i % 2 == 0) { // we have an even index
        while (A[i] % 2 != 0) { // while the items are not even
          exchange(A, i, lastOddIndex); // This will put odd item into last odd index
          lastOddIndex -= 2; // update last odd index
        }
      } else { // we have an odd index
        while (A[i] % 2 == 0) { // while the items are even
          exchange(A, i, lastEvenIndex); // put the even items into last even index
          lastEvenIndex -= 2; // update last even index
        }
      }
    }
    return A;
  }

  private void exchange(int[] A, int i, int index) {
    int temp = A[i];
    A[i] = A[index];
    A[index] = temp;
  }
}