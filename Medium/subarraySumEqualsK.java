class Solution {
    int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> exploredSums = new HashMap<>();
        exploredSums.put(0, 1); // for a sum of 0, we get exactly one solution.
        int[] sumCount = { 0 };

        return IntStream.of(nums).reduce(0, (accumulator, currentValue) -> {
            sumCount[0] = sumCount[0] + currentValue;
            int currentCount = accumulator + exploredSums.getOrDefault(sumCount[0] - k, 0);
            exploredSums.merge(sumCount[0], 1, Integer::sum);
            return currentCount;
        });
    }
}