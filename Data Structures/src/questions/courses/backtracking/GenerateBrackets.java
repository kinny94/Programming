package questions.courses.backtracking;

public class GenerateBrackets {

    public static void generateBrackets(int num) {
        generateBrackets("", num, 0, 0, 0);
    }

    private static void generateBrackets(String output, int n, int open, int close, int i) {
        // base case
        if (i == 2*n) {
            System.out.println(output);
            return;
        }

        // open
        if (open<n) {
            generateBrackets(output + "(", n, open + 1, close, i + 1);
        }

        if (close < open) {
            generateBrackets(output + ")", n, open, close + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generateBrackets(n);
    }

}
