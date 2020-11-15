object Solution {
  def subarraySum(nums: Array[Int], k: Int): Int = {}
}

/*
G: nums: Array[Int], k: Int
O: totalContArrsSumEqualsK: Int
T: ???
S: ???

Notes:
 * Return number of continuous subarrays whose sum equals K

Ex:

[1,1,1], k = 2

count = 2

  1 1 1    |      k = 2
    i
      j

Ex2:
[1,2,3], k = 3

count = 2

1 2 3      3
    i
    j

Ex3:

[1,2,3,4,5] => 5

count = 2
futureSum = 5 if future sum == k update count
cSum = 4 < 5

1 2 3 4 5 | 5
        i
        j

 */
