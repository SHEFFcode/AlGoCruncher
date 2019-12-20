object Solution {
    def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
        if (nums.length < 2) return Nil
        val numberSet = nums.toSet
        val min = Math.min(nums.min, 1)
        val max = Math.max(nums.max, nums.length)
        val result = (min to max).filter(!numberSet(_))

        result.toList
    }
}


/*
    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

    Find all the elements of [1, n] inclusive that do not appear in this array.

    Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

    Input:
    [4,3,2,7,8,2,3,1]
     *

    Output:
    [5,6]
     *

    Set[int] {
        4, 3, 2,7,8,2,3,1
    }

    largestNumber = 8
    smallestNumber = 1

    1 to 8.foreach { i => 
        if (!set.contains(i)) {
            resultList :+ i
        }
    }

    return resultList
*/