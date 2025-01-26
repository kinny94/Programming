package questions.leetcode;

import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {
    public String minRemoveToMakeValid(String s) {
//        Stack<int[]> stack = new Stack<>();
//        char[] arr = s.toCharArray();
//
//        for (int i=0; i<s.length(); i++) {
//            char currentChar = s.charAt(i);
//            if (!stack.isEmpty() && stack.peek()[0] == '(' && currentChar == ')') {
//                stack.pop();
//            } else if (currentChar == ')' || currentChar == '('){
//                stack.push(new int[]{currentChar, i});
//            }
//        }
//
//        while(!stack.isEmpty()) {
//            arr[stack.pop()[1]] = ' ';
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (char c: arr) {
//            if (c != ' ') {
//                sb.append(c);
//            }
//        }
//        return sb.toString();

        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openSeen++;
                balance++;
            } if (c == ')') {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }

        System.out.println(sb.toString());
        // Pass 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0) continue;
            }
            result.append(c);
        }

        return result.toString();
    }


}
