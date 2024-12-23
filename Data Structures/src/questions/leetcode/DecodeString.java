package questions.leetcode;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> string = new Stack<>();
        int k = 0;
        StringBuilder current = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + Character.getNumericValue(c);
            } else if (c == '[') {
                count.push(k);
                string.push(current.toString());
                k = 0;
                current.setLength(0);
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(string.pop());
                int top = count.pop();
                for (int i=0 ;i<top; i++) {
                    temp.append(current);
                }
                current = temp;
            } else {
                current.append(c);
            }
        }
        return current.toString();
    }
}
