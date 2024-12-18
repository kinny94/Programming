package questions.leetcode;

import java.util.Arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();

        if (totalCost > totalGas) {
            return -1;
        }

        int currentGas = 0;
        int startIndex = 0;

        for (int i=0; i<gas.length; i++) {
            currentGas = currentGas + gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startIndex = i + 1;
            }
        }
        return startIndex;
    }
}
