/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = calculateMaxDepth(nestedList, 1);

        return helper(nestedList, maxDepth);
    }

    private int calculateMaxDepth(List<NestedInteger> nestedList, int depth) {
        int cDepth = depth;

        for (int i = 0; i < nestedList.size(); i++) {
            if (!nestedList.get(i).isInteger()) {
                cDepth = Math.max(cDepth, calculateMaxDepth(nestedList.get(i).getList(), depth + 1));
            }
        }

        return cDepth;
    }

    private int helper(List<NestedInteger> list, int depth) {
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isInteger()) {
                sum += list.get(i).getInteger() * depth;
            } else {
                sum += helper(list.get(i).getList(), depth - 1);
            }
        }

        return sum;
    }

}