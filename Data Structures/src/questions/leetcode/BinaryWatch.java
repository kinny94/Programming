package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> results = new ArrayList<>();
        solve(0, 0, 0, turnedOn, results);
        return results;
    }

    public void solve(int position, int hours, int minutes, int enabled, List<String> results) {
        if (enabled == 0) {
            if (hours <= 11 && minutes <= 59) {
                String time = hours + ":" + (minutes < 10 ? "0" : "") + minutes;
                results.add(time);
            }
            return;
        }

        for (int i=position; i<10; i++) {
            int h = hours;
            int m = minutes;
            if (i<=3) {
                hours += (int) Math.pow(2, i);
            } else {
                minutes += (int) Math.pow(2, i - 4);
            }
            solve(i + 1, hours, minutes, enabled -1, results);
            hours = h;
            minutes = m;
        }
    }
}
