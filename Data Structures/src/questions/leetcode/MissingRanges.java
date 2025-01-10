package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ranges = new ArrayList<>();
        int start = lower;

        for (int num: nums) {
            if (num > upper) {
                break;
            }
            if (num < start) {
                continue;
            }
            if (num > start) {
                ranges.add(Arrays.asList(start, num - 1));
            }
            start = num + 1;
        }

        if (start <= upper) {
            ranges.add(Arrays.asList(start, upper));
        }

        return ranges;
    }
}
