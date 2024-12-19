package questions.leetcode;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChilren = 0;
        int currentChild = 0;
        int currentCookie = 0;

        while(currentChild < g.length && currentCookie < s.length) {
            if (s[currentCookie] >= g[currentChild]) {
                currentChild++;
                contentChilren++;
            }
            currentCookie++;
        }
        return contentChilren;
    }
}
