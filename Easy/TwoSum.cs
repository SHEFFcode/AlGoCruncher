public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        var dictionary = new Dictionary<int, int>();
        var indexArray = new int[2];
        var integer = 0;
        for (var i = 0; i < nums.Length; i++)
        {
            integer = nums[i];
            if (dictionary.ContainsKey(integer))
            {
                indexArray[0] = dictionary[integer];
                indexArray[1] = i;
            }
            else if (integer < target)
            {
                dictionary.Add(target - integer, i);
            }
        }

        return indexArray;
    }
}

/*
G: int[]
O: An int[] of indecies of 2 numbers that add up to a specific number
T: Any
S: Any

Notes:
* Each input can have only one solution.

Example:
nums = [2, 7, 11, 15] target = 9  => [0, 1]

Solution:
i: [2, 7, 11, 15] , 9 => we want to do 9 less the number at index, and see if the other number exists in the array
    *               9 - 2 = 7, we will add 7 to a hash table { 7: 0 } because the index of the item that matched with 7 is at index 0
1: [2, 7, 11, 15]  { 7: 0 } Check if 7 is in the data structure and if so, return its index and the value of hash @ 7
       *

 */