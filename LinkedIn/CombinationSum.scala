object Solution {
    def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
        val result: List[List[Int]] = Nil
        combinationSumHelper(candidates, target, result, 0, Nil)
        result
    }

    private def combinationSumHelper(
        candidates: Array[Int],
        target: Int,
        result: List[List[Int]],
        index: Int,
        currentList: List[Int]
    ): List[List[Int]] = {
        if (currentList.sum + candidates(index) == target) {
            result + (currentList + candidates(index))
        } else if (currentList.sum + candidates(index) < target) {
            combinationSumHelper(candidates, target, result, index, currentList + candidates(index))
        } else {
            combinationSumHelper(candidates, target, result, index + 1, currentList--)
        }
        combinationSumHelper(candidates, target, result, index + 1, currentList--)
    }
}

/*
candidates = [2,3,6,7], target = 7

[2, 3, 6, 7] 7
    *



[2], 2
[2, 3], 5
[2, 3, 6], 11, since > 7, unchoose 6
[2, 3, 7], 12, since > 7, unchoose 7
pop off unchoose 3
[2, 6]. since 8 > 7, unchoose
[2, 7], since 9 > 7, unchoose
pop off 2
[6, 7], 13 > 7, so unchoose 6
[7], so add 7


val currentSeq = currentSeq + head

case head == goal => result + List(currentSeq)




This seems like a recursive problem, with choose explore unchoose goal, until we exhaus the decision space
We have a decision space and we can either pick or not pick the item.

Our goal is to reach 7, and if we do we will append that to a list.

If we go above 7, we will unchoose and move on



*/