package questions.leetcode.Meta.Intervals;

import java.util.ArrayList;
import java.util.List;

public class    MergeIntervalII {
    public static int[][] merge(int[][] first, int[][] second) {
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();

        int[] prev = null;
        while (i < first.length || j <second.length) {
            int[] curr = null;

            if (i >= first.length) {
                curr = second[j];
                j++;
            } else if (j >= second.length) {
                curr = first[i];
                i++;
            } else if (first[i][0] < second[j][0]) {
                curr = first[i];
                i++;
            } else {
                curr = second[j];
                 j++;
            }

            if (prev == null) {
                prev = curr;
            } else {
                if (prev[1] < curr[0]) {
                    result.add(prev);
                    prev = curr;
                } else {
                    prev[1] = Math.max(prev[1], curr[1]);
                }
            }
        }

        if (prev != null) {
            result.add(prev);
        }

        for (int[] num : result) {
            System.out.print("[" + num[0] + " , " + num[1] + "] ");
        }

        return result.toArray(new int[][]{});
    }
}
