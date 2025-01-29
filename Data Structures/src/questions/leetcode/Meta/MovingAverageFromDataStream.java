package questions.leetcode.Meta;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverageFromDataStream {

    private int size;
    private Queue<Integer> queue;
    private double windowSum;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        windowSum = 0;
    }

    public double next(int val) {
        queue.add(val);
        windowSum += val;

        if (queue.size() > size) {
            windowSum -= queue.poll();
        }

        return windowSum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
