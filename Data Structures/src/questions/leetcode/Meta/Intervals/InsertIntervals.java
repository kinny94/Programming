package questions.leetcode.Meta.Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();
        //output.add(intervals[0]);

        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(newInterval == null || end < newInterval[0]){
                output.add(intervals[i]);
            }
            else if(start > newInterval[1]){
                output.add(newInterval);
                output.add(intervals[i]);
                newInterval = null;
            }
            else{
                newInterval[0] = Math.min(start, newInterval[0]);
                newInterval[1] = Math.max(end, newInterval[1]);
            }
        }
        if(newInterval != null)
            output.add(newInterval);

        return output.toArray(new int[output.size()][]);
    }
}
