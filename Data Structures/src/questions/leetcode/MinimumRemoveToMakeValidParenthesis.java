package questions.leetcode;

import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {
    public String minRemoveToMakeValid(String s) {
        Stack<int[]> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!stack.isEmpty() && stack.peek()[0] == '(' && currentChar == ')') {
                stack.pop();
            } else if (currentChar == ')' || currentChar == '('){
                stack.push(new int[]{currentChar, i});
            }
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()[1]] = ' ';
        }

        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
