package questions.leetcode;

import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedulingCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int cost = 0, n = costs.length;

        for(int i = 0; i < n; i++) {
            if(i < n / 2)
                cost += costs[i][0];
            else
                cost += costs[i][1];
        }

        return cost;
    }
}
