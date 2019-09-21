class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        
        if (nums.length == 0) {
            addToRanges(Long.valueOf(lower - 1), Long.valueOf(upper + 1), result);
            return result;
        }

        if (nums[0] != lower) {
            addToRanges(Long.valueOf(lower - 1), Long.valueOf(nums[0]), result);
        }


        for (int i = 0, j = i + 1; j < nums.length; j++, i++) {
            if (Math.abs(Long.valueOf(nums[j]) - Long.valueOf(nums[i])) > 1) {
                addToRanges(Long.valueOf(nums[i]), Long.valueOf(nums[j]), result);
            }
        }
        
        if (nums[nums.length - 1] != upper) {
            addToRanges(Long.valueOf(nums[nums.length - 1]), Long.valueOf(upper + 1), result);
        }

        return result;
    }

    private void addToRanges(long startNum, long endNum, List<String>result) {
        long range = endNum - 1 - startNum;
        if (range == 1) {
            result.add("" + (startNum + 1));
        } else {
            long start = startNum + 1; // 76
            long end = endNum - 1; // 99
            result.add("" + (int)start + "->" + (int)end);
        }
    }
}

/**
 *  Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
    Output: ["2", "4->49", "51->74", "76->99"]


    we will add the start and end as follows:
    if the first number is not start number, add startNumber - 1
    if the last number is not the end number, add endNumber + 1

    [0, 1, 3, 50, 75, 100]
                  i  j

     if (nums[j] - nums[i] != 1) {
         missingRanges.add(nums[j] - nums[i]) // this function will figure out what to append
     }



     def addRanges(1, 3):
     range = endNum - 1 - startNum
     if (range == 1) {
         missingRanges.add(num.toString())
     } else {
         start = startNum + 1; // 76
         end = endNum - 1; // 99
         missingRanges.add("" + startNum + "->" + endNum)
     }
     ["2", "4->49", "51->74", "76 -> 99"]
 */