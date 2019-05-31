class Solution {
    public int subarraySum(int[] nums, int k) {
        int remainder = k;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            remainder = k;
            for (int j = i; j < nums.length; j++) {
                remainder -= nums[j];
                if (remainder == 0) {
                    System.out.println("The number of nums is " + nums[j]);
                    System.out.println("Count is " + (count + 1));
                    System.out.println("Remainder is " + (remainder));
                    count++;
                    // if match is found, ++ the count by each subsequent 0
                    while (j + 1 < nums.length && nums[j + 1] == 0) {
                        System.out.println("The number of nums is " + nums[j + 1]);
                            System.out.println("J is " + (j + 1));
                            System.out.println("Count is " + (count + 1));
                        j++;
                        count++;
                    }
                    remainder = k;
                    break;
                }

                if (remainder < 0) {
                    remainder = k; // reset here
                    break;
                }
            }
        }

        return count;
    }
}