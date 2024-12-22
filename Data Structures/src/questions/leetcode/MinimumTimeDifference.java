package questions.leetcode;

import java.time.LocalTime;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        // Convert time points to minutes (from 00:00 to 23:59)
        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
            LocalTime localTime = LocalTime.parse(timePoints.get(i));
            minutes[i] = localTime.getHour() * 60 + localTime.getMinute();
        }

        // Create a boolean array to mark the presence of time points
        boolean[] seen = new boolean[1440];  // There are 1440 minutes in a day (24 * 60)

        // If there are any duplicate times, the minimum difference is 0
        for (int time : minutes) {
            if (seen[time]) {
                return 0;
            }
            seen[time] = true;
        }

        // Find the first and last time points
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 1440; i++) {
            if (seen[i]) {
                if (first == Integer.MAX_VALUE) {
                    first = i;
                }
                last = i;
            }
        }

        // Now calculate the minimum difference between consecutive time points
        int minDiff = Integer.MAX_VALUE;

        // Loop through the seen times and calculate the min difference
        int prev = first;
        for (int i = first + 1; i <= last; i++) {
            if (seen[i]) {
                minDiff = Math.min(minDiff, i - prev);
                prev = i;
            }
        }

        // Handle the circular case (difference between the last and first time point)
        minDiff = Math.min(minDiff, (1440 - last) + first);

        return minDiff;
    }
}
