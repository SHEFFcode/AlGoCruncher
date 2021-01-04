object Solution {
  def permute(nums: Array[Int]): List[List[Int]] = {
    if (nums.isEmpty) {
      List(List())
    } else {
      for {
        x <- nums.toList
        perm <- permute(nums.filter(_ != x))
      } yield x :: perm
    }
  }
}

/*
G: nums: Array[Int]
O: allPermustations: List[List[Int]]
T: O(N)
S: O(N)

Notes:
  - Integers in the nums are distinct
  - Number of permutations is n!

Ex:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 */
