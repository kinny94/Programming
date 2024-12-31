package questions.leetcode;

import java.util.*;

class MaxStack {

    private List<int[]> stack;
    private PriorityQueue<int[]> maxHeap;
    private Set<Integer> popped;
    private int idNum;

    public MaxStack() {
        stack = new ArrayList<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        this.popped = new HashSet<>();
        this.idNum = 0;
    }

    public void push(int x) {
        stack.add(new int[]{x, idNum});
        maxHeap.add(new int[]{x, idNum});
        idNum++;
    }

    public int pop() {
        while(popped.contains(stack.get(stack.size() - 1)[1])) {
            stack.remove(stack.size() - 1);
        }
        int[] top = stack.remove(stack.size() - 1);
        popped.add(top[1]);
        return top[0];
    }

    public int top() {
        while(popped.contains(stack.get(stack.size() - 1)[1])) {
            stack.remove(stack.size() - 1);
        }
        return stack.get(stack.size() - 1)[0];
    }

    public int peekMax() {
        while(popped.contains(maxHeap.peek()[1])) {
            maxHeap.poll();
        }
        return maxHeap.peek()[0];
    }

    public int popMax() {
        while(popped.contains(maxHeap.peek()[1])) {
            maxHeap.poll();
        }
        int[] top = maxHeap.poll();
        popped.add(top[1]);
        return top[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */