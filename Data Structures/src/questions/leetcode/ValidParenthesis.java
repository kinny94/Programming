package questions.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
