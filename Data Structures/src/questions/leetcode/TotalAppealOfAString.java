package questions.leetcode;

import java.util.Arrays;

public class TotalAppealOfAString {
    public long appealSum(String s) {
        int[] track = new int[26];
        Arrays.fill(track, -1);
        long res = 0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            res += (long) (i - track[c - 'a']) * (s.length() - i);
            track[c - 'a'] = i;
        }
        return res;
    }
}
