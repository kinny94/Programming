package questions.leetcode;

import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    private Stack<NestedInteger> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        // Initialize the stack with reversed nestedList
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    // @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        }
        return 0;
    }

    //@Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger()) {
                return true;
            }

            List<NestedInteger> nestedList = stack.pop().getList();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }
        return false;
    }
}
