object Solution {
  def candy(ratings: Array[Int]): Int = {
    val nChildren = ratings.length
    val candyCount = Array.fill(nChildren)(1)

    // First pass, see notes below
    for (idx <- 1 until nChildren) {
      if (ratings(idx - 1) < ratings(idx)) {
        candyCount(idx) = candyCount(idx - 1) + 1
      }
    }

    // Second pass, see notes below
    for (idx <- nChildren - 2 to 0 by -1) {
      if (ratings(idx + 1) < ratings(idx)) {
        candyCount(idx) = math.max(candyCount(idx), candyCount(idx + 1) + 1)
      }
    }

    candyCount.sum
  }
}

/*
G: ratings: Array[Int]
O: minCandiesRequired: Int
T: Any
S: Any

Notes:
 * Each child must have at least 1 candy
 * Child with higher rating then neighbors will get more candy

Ex:
[1,0,2] => 5

[ 1, 0, 2 ]

[ 2, 1, 2 ].sum() = 5
 *

Ex2:
[1,2,2] => 4

[ 1, 2, 2 ]
 *
[ 1, 2, 2 ]

Ex3:
[1,2,3] => 6

[ 1, 2, 3 ]
 *
[ 1, 2, 3 ].sum() = 6

Ex4:

[ 3, 2, 2, 3, 2, 1 ]
 *
[ 2, 1, 1, 3, 2, 1]



Basic approach will be to go through the array 2n times:
  1) Right to left
  2) Left to right

As we are going through the children 1st time, we will look at the child to our left:
  - If he is lower ranked, we will give the current child 1 more candy then previous
  - If the child is higher or same rank, we will do nothing

As we are going through the children the s2d time, we will look @ child to our right:
  - If he is lower ranked, we will give us max(1 + hist candy count, our current count)
  - If he is higher or same rank, we will do nothing
 */
