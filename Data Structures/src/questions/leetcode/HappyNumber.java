package questions.leetcode;

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sunmOfSquared(n);

        while (fast != 1 && slow != fast) {
            slow = sunmOfSquared(slow);
            fast = sunmOfSquared(sunmOfSquared(fast));
        }
        return fast == 1;
    }

    private int sunmOfSquared(int n) {
        int total = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n/10;
            total += Math.pow(digit, 2);
        }
        return total;
    }
}
