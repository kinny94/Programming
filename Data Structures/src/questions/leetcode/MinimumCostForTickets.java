package questions.leetcode;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int maxDay = days[n -1];
        int minDay = days[0];

        int[] dp = new int[maxDay + 1];
        boolean[] isTravelDay = new boolean[maxDay + 1];

        for (int day: days) {
            isTravelDay[day] = true;
        }

        for(int i=minDay; i<=maxDay; i++) {
            if (!isTravelDay[i]) {
                dp[i] = dp[i-1];
            } else {
                int dayCost = i - 1 >= 0 ? costs[0] + dp[i-1] : costs[0] + dp[0];
                int weekCost = i - 7 >= 0 ? costs[1] + dp[i-7] : costs[1] + dp[0];
                int monthCost = i - 30 >= 0 ? costs[2] + dp[i-30] : costs[2] + dp[0];
                dp[i] = Math.min(Math.min(dayCost, weekCost), monthCost);
            }
        }

        return dp[maxDay];
    }
}
