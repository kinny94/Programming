package questions.leetcode;

import java.util.List;

public class NestedListWeighSumII {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private int getMaxDepth(List<NestedInteger> nestedList) {
        int maxDepth = 0;
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger() && !ni.getList().isEmpty()) {
                maxDepth = Math.max(maxDepth, 1 + getMaxDepth(ni.getList()));
            }
        }
        return maxDepth;
    }

    private int solve(List<NestedInteger> nestedList, int depth, int maxDepth) {
        int result = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                result += ni.getInteger() * (maxDepth - depth + 1);
            } else {
                result += solve(ni.getList(), depth + 1, maxDepth);
            }
        }
        return result;
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth(nestedList);
        return solve(nestedList, 0, maxDepth);
    }
}
