class Solution {
    public List<String> addOperators(String num, int target) {
        Map<String, Set<Integer>> decisionSpaceToPossibleOutcomesMap = new HashMap()<>; // our cache
        List<String> opsToTargetValue = new ArrayList<>(); // no off the top of my head reasonable value
        int offser = 1;

        // Let's solve part one of this problem, which is coming up with all possible numbers, and turn that into a deicison space that we can use
        List<Integer> allPossibleNums = new ArrayList<>();
        permuteNums(num, 0, allPossibleNums);

        // Let's now use the numeric decision space and iterate through it with our static decision space
        permuteNumbersWithOperators(allPossibleNums)
        
        return opsToTargetValue;
    }

    private void permuteChars(String num, int offset, List<Integer> permutations) {
        for (int i = 0; i + offset < nums.length; i++) {
            String cPermutation = nums.subString(i, i + offset);
            permutations.add(cPermutation);
            permuteChars(num, offset + 1, permutations);
        }
    }

    private void permuteNumbersWithOperators(List<Integer> numsRemaining, List<String> result, Map<String, HasMap<Integer, String>> map) {
        int cInt = numsRemaining.remove(0); // let's get the first number in the list.
        if (map.containsKey(numsRemaining.toString())) {
            Map<Integer> precomputedResults = map.get(numsRemaining.toString());
            if (precomputedResults.containsKey(target - cInt)) {
                numsRemaining.add("" + cInt + "+" + precomputedResults.get(target - cInt));
            } else if (precomputedResults.containsKey(target + cInt)) {
                numsRemaining.add("" + cInt + "-" + precomputedResults.get(target - cInt));
            } else if (precomputedResults.containsKey(target / cInt)) {
                numsRemaining.add("" + cInt + "*" + precomputedResults.get(target - cInt));
            }
        }
        if (cInt + permuteNumbersWithOperators(new ArrayList<>(numsRemaining), result, map)) {

        }
    }
}

/**
 *  Input: num = "123", target = 6
    Output: ["1+2+3", "1*2*3"]

    decision space: [+, -. *] repeated, does not get reduced && [123] not repeated, decision space gets reduced

    1 2 3      6
    i

    so it's gonna be"

                                                        root
                        1 + recusion([2, 3]) 1 - recursion([2, 3]) 1 * recursion([2, 3]) || 12 + recursion([3]) || 123 + recursion([])
                1 + 2 + recursion([3]) | 1 + 2 - recursion([3]) | 1 + 2 * recursion*([3])

            1 + 2 + 3 | 1 + 2 - 3 | 1 + 2 * 3       1 - 2 + 3 |  1 - 2 - 3 | 1 - 2 * 3   1 * 2 + 3 | 1 * 2 - 3 | 1 * 2 * 3    

        
        {
            [2,3]: {5, -1, 6}, // we will then look if target / set(decisionSpace) == cNumber || target - set(decisionSpace) == cNumber || target + set(decisionSpace) == cNumber
        }

        if so we will add it to our List<String result>

        if input == target, we should add that to the list as well

 */