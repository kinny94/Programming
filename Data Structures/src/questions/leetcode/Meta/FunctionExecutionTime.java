package questions.leetcode.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FunctionExecutionTime {
    public static Map<String, Integer> calculateFunctionTimes(String[] logs) {
        Map<String, Integer> result = new HashMap<>();
        Stack<String> stack = new Stack<>();
        int prevTime = 0;

        for (String log: logs) {
            String[] parts = log.split(" ");
            String func = parts[0];
            int time = Integer.parseInt(parts[1]);

            // If the stack is not empty, calculate the time for the currently active function
            if(!stack.isEmpty()) {
                // Add time to the currently active function
                // Get the function at the top of the stack
                String activeFunc = stack.peek();
                // Add the time difference to the active function's total time
                result.put(activeFunc, result.getOrDefault(activeFunc, 0) + time - prevTime);
            }

            // If the current function is already at the top of the stack, it means this is its ending log
            if (!stack.isEmpty() && stack.peek().equals(func)) {
                stack.pop();
            } else {
                // Otherwise, this is the start of a new function call
                stack.push(func);
                result.putIfAbsent(func, 0);
            }
            // Update the previous timestamp for the next iteration
            prevTime = time;
        }

        return result;

    }

    public static void main(String[] args) {
        String[] logs = {
                "foo 0",
                "bar 10",
                "bar 30",
                "foobar 50",
                "foobar 70",
                "foo 100"
        };

        Map<String, Integer> result = calculateFunctionTimes(logs);

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Output: {foo=60, bar=20, foobar=20}
    }
}
