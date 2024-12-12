package questions.leetcode;

public class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0;
        int points = 0;

        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }

        if (sum > upper) {
            points++;
        }

        if (sum < lower) {
            points--;
        }

        for (int i = k; i < calories.length; i++) {
            sum = sum - calories[i - k] + calories[i];
            if (sum > upper) {
                points++;
            }

            if (sum < lower) {
                points--;
            }
        }
        return points;
    }
}