package questions.leetcode.Meta.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));

        if (intervals.length == 0) {
            return new int[][]{};
        }

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i=1; i<intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[]lastAddedInterval = result.get(result.size() - 1);
            if (currentInterval[0] <= lastAddedInterval[1]) {
                lastAddedInterval[1] = Math.max(currentInterval[1], lastAddedInterval[1]);
            } else {
                result.add(new int[]{currentInterval[0], currentInterval[1]});
            }
        }

        return result.toArray(new int[][]{});
    }
}
