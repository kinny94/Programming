package questions.leetcode.Meta;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        int minLength = Math.min(s1.length(), s2.length());
        int index = 0;
        for (int i=0; i<minLength; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                index++;
            } else {
                break;
            }
        }

        return s1.substring(0, index);
    }

    public String verticalScan(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c
                ) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
