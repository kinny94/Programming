package questions.leetcode;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s: components) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(s);
            }



        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();

    }
}
