package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(n, 0, 0, sb, result);
        return result;
    }

    private void solve(int n, int leftCount, int rightCount, StringBuilder sb, List<String> result) {
        if (leftCount == n && rightCount == n) {
            result.add(sb.toString());
            return;
        }

        if (leftCount < n) {
            sb.append('(');
            solve(n, leftCount + 1, rightCount, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (rightCount < leftCount) {
            sb.append(')');
            solve(n, leftCount, rightCount + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
