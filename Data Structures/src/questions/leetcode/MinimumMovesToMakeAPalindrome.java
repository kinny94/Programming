package questions.leetcode;

public class MinimumMovesToMakeAPalindrome {
    public int minMovesToMakePalindrome(String s) {

        int moves = 0;
        char[] chars = s.toCharArray();
        for (int i=0, j=chars.length - 1; i<j; i++)  {
            int k = j;
            for (; k > i; k--) {
                if (chars[i] == chars[k]) {
                    for (;k <j; k++) {
                        char temp = chars[k];
                        chars[k] = chars[k + 1];
                        chars[k+1] = temp;
                        moves++;
                    }
                    j--;
                    break;
                }
            }
            if (k == i) {
                moves += chars.length / 2 - i;
            }
        }
        return moves;
    }
}
