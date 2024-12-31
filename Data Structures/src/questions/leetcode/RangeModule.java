package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

class RangeModule {

    private List<int[]> ranges;

    public RangeModule() {
        ranges = new ArrayList<>();
    }

    private int[] checkIntervals(int left, int right) {
        int minRange = 0;
        int maxRange = ranges.size() - 1;
        int mid = ranges.size() / 2;

        while (mid >= 1) {
            while (minRange + mid < ranges.size() && ranges.get(minRange + mid - 1)[1] < left) {
                minRange += mid;
            }

            while (maxRange - mid >= 0 && ranges.get(maxRange - mid + 1)[0] > right) {
                maxRange -= mid;
            }
            mid = mid / 2;
        }
        return new int[]{minRange, maxRange};
    }

    public void addRange(int left, int right) {
        if (ranges.isEmpty() || ranges.get(ranges.size() - 1)[1] < left) {
            ranges.add(new int[]{left, right});
            return;
        }

        if (ranges.get(0)[0] > right) {
            ranges.add(0, new int[]{left, right});
            return;
        }

        int[] indices = checkIntervals(left, right);
        int minRange = indices[0];
        int maxRange = indices[1];
        int updatedLeft = Math.min(ranges.get(minRange)[0], left);
        int updatedRight = Math.max(ranges.get(maxRange)[1], right);
        ranges.subList(minRange, maxRange + 1).clear();
        ranges.add(minRange, new int[]{updatedLeft, updatedRight});
    }

    public boolean queryRange(int left, int right) {
        if (ranges.isEmpty()) {
            return false;
        }

        int[] indices = checkIntervals(left, right);
        int minRange = indices[0];
        return ranges.get(minRange)[0] <= left && right <= ranges.get(minRange)[1];
    }

    public void removeRange(int left, int right) {
        if (ranges.isEmpty() || ranges.get(0)[0] > right || ranges.get(ranges.size() - 1)[1] < left) {
            return;
        }
        int[] indices = checkIntervals(left, right);
        int minRange = indices[0];
        int maxRange = indices[1];

        List<int[]> updatedRanges = new ArrayList<>();
        for (int i=minRange; i<= maxRange; i++) {
            if (ranges.get(i)[0] < left) {
                updatedRanges.add(new int[]{ranges.get(i)[0], left});
            }

            if (ranges.get(i)[1] > right) {
                updatedRanges.add(new int[]{right, ranges.get(i)[1]});
            }
        }
        ranges.subList(minRange, maxRange + 1).clear();
        ranges.addAll(minRange, updatedRanges);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */