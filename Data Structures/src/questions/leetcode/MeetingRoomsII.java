package questions.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval: intervals) {
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.offer(interval[1]);
        }

        return minHeap.size();
    }

    public int minMeetingRooms2(int[][] intervals) {
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int meetingRooms = 0;
        int startPointer = 0, endPointer = 0;

        while(startPointer < startTime.length){
            if(startTime[startPointer] >= endTime[endPointer]){
                meetingRooms--;
                endPointer++;
            }

            meetingRooms++;
            startPointer++;
        }

        return meetingRooms;
    }
}
