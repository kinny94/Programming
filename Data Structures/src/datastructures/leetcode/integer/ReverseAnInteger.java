package datastructures.leetcode.integer;

public class ReverseAnInteger {
    public int reverse(int x) {
        int remainder = 0;
        int reversed = 0;

        while (x != 0) {
            remainder = x % 10;
            x = x / 10;
            if (reversed > Integer.MAX_VALUE/10 || reversed < Integer.MIN_VALUE/10) {
                return 0;
            }
            reversed = reversed * 10 + remainder;
        }

        return reversed;
    }
}
