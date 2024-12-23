package questions.leetcode;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    class Pair {
        int id;
        int startTime;
        int childTime;

        public Pair(int id, int startTime, int childTime) {
            this.id = id;
            this.startTime = startTime;
            this.childTime = childTime;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Pair> stack = new Stack<>();
        int[] result = new int[n];

        for  (int i=0; i<logs.size(); i++) {
            String[] log = logs.get(i).split(":");
            System.out.println(log[0]);;

            if (log[1].equals("start")) {
                int id = Integer.parseInt(log[0]);
                int startTime = Integer.parseInt(log[2]);
                stack.push(new Pair(id, startTime, 0));
            } else {
                Pair top = stack.pop();
                int interval = Integer.parseInt(log[2]) - top.startTime + 1;
                int time = interval - top.childTime;
                result[top.id] += time;

                if (stack.size() > 0) {
                    stack.peek().childTime += interval;
                }
            }
        }

        return result;
    }
}
