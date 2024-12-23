package questions.leetcode;

import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[temperatures.length];
        for (int i=0;i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                output[j] = i - j;
            }
            stack.push(i);
        }
        return output;
    }
}
