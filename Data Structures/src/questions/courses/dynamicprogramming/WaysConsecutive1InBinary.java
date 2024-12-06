package questions.courses.dynamicprogramming;

public class WaysConsecutive1InBinary {
    public static int numOfWays(int n) {
        return numOfWays(1, n, false);
    }

    private static int numOfWays(int index, int n, boolean isPreviousValueOne) {
        if (index == n + 1) {
            return 1;
        }

        int ans = 0;
        // starting with 0
        ans += numOfWays(index + 1, n, false);

        // or start with 1
        if (!isPreviousValueOne) {
            ans += numOfWays(index + 1, n, true);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(numOfWays(n));
    }
}
