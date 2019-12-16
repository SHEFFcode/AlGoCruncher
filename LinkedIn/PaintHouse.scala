/*
Input: [
    i [17,2,17]
            
    i [16,16,5]
       j
     [14,3,19]
]


Memory: [
    [17, 2, 17] => first row remains as is

    [16 + min(2, 17), 16 + min(17, 17), 5 + min(17, 2)] => second row we see what the min addition is for positions other then current in the previous
    [18, 33, 7] => result of the calculation above

    [14 + min(7, 33), 3 + min(18, 7), 19 + min(18, 33)] => same thing, for this house let's make a choice based on the best choice of the previous choices
    [21, 10, 37]
]

Now that we have seen the all the houses, let's make the best most optimal solution

[21, 10, 37], min here is 10



==========================================================================

Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 
             Minimum cost: 2 + 5 + 3 = 10.


    G: input: Array[Array[Int]] row of houses, with costs of painting
    O: minCost: Int - minimum cost to paint all houses
    T: 3 O(n)
    S: O(n)
    Notes:
        - All costs are positive integers
*/

object Solution {
    def minCost(costs: Array[Array[Int]]): Int = {
        if(costs == null || costs.length == 0) {
            return 0
        }

        val cache = costs.clone()
        
        for(i <- 1 to (costs.length - 1)) {
            cache(i)(0) = costs(i)(0) + Math.min(cache(i - 1)(1), cache(i - 1)(2))
            cache(i)(1) = costs(i)(1) + Math.min(cache(i - 1)(0), cache(i - 1)(2))
            cache(i)(2) = costs(i)(2) + Math.min(cache(i - 1)(0), cache(i - 1)(1))
        }

        Math.min(
            Math.min(cache(costs.length - 1)(0), cache(costs.length - 1)(1)),
            cache(costs.length - 1)(2)
        )
    }
}


// object Solution {
//     def minCost(costs: Array[Array[Int]]): Int = {
//         val cache = Array.ofDim[Int](costs.length, 3)

//         costs.zipWithIndex.foreach {
//             case (arr, arrIndex) => {
//                 if (arrIndex == 0) {
//                     arr.zipWithIndex.foreach {
//                         case (item, index) => cache(0)(index) = item
//                     }
//                 } else {
//                     arr.zipWithIndex.foreach {
//                         case (item, index) => index match {
//                             case 0 => cache(arrIndex)(0) += item + Math.min(cache(arrIndex - 1)(1), cache(arrIndex - 1)(2))
//                             case 1 => cache(arrIndex)(1) += item + Math.min(cache(arrIndex - 1)(0), cache(arrIndex - 1)(2))
//                             case 2 => cache(arrIndex)(2) += item + Math.min(cache(arrIndex - 1)(0), cache(arrIndex - 1)(1))
//                         }
//                     }
//                 }
//             }
//         }

//         Math.min(cache(costs.length - 1)(0), Math.min(cache(costs.length - 1)(1), cache(costs.length - 1)(2)))
//     }
// }