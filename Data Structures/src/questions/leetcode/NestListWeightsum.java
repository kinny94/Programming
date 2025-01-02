package questions.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestListWeightsum {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
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

    class NestListWeightsum {
        public int depthSum(List<NestedInteger> nestedList) {
            Queue<NestedInteger> queue = new LinkedList<>();
            queue.addAll(nestedList);

            int depth = 1;
            int total = 0;

            while(!queue.isEmpty()) {
                int size = queue.size();
                for (int i=0; i<size; i++) {
                    NestedInteger ni = queue.poll();
                    if (ni.isInteger()) {
                        total += ni.getInteger() * depth;
                    } else {
                        queue.addAll(ni.getList());
                    }
                }
                depth++;
            }
            return total;
            // return dfs(nestedList, 1);
        }

        public int dfs(List<NestedInteger> list,  int depth) {
            int total = 0;
            for (int i=0; i<list.size(); i++) {
                if (list.get(i).isInteger()) {
                    total += list.get(i).getInteger() * depth;
                } else{
                    total += dfs(list.get(i).getList(), depth + 1);
                }
            }
            return total;
        }

    }
}
