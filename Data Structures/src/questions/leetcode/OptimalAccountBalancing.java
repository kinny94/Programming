package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balanceMap = new HashMap<>();

        for (int[] transaction: transactions) {
            int a = transaction[0];
            int b = transaction[1];
            int amount = transaction[2];
            balanceMap.put(a, balanceMap.getOrDefault(a, 0) + amount);
            balanceMap.put(b, balanceMap.getOrDefault(b, 0) - amount);
        }

        List<Integer> balanceList = new ArrayList<>();
        for (int amount: balanceMap.values()) {
            if (amount != 0) {
                balanceList.add(amount);
            }
        }

        int[] balance = new int[balanceList.size()];
        for (int i=0; i<balanceList.size(); i++) {
            balance[i] = balanceList.get(i);
        }

        int n = balance.length;
        return dfs(0, n, balance);
    }


    public int dfs(int current, int n, int[] balance) {
        while (current < n && balance[current] == 0) {
            current++;
        }

        if (current == n) {
            return 0;
        }

        int cost = Integer.MAX_VALUE;

        for (int next=current + 1; next < n; next++) {
            if (balance[next] * balance[current] < 0) {
                balance[next] += balance[current];
                cost = Math.min(cost, 1 + dfs(current + 1, n, balance));
                balance[next] -= balance[current];
            }
        }
        return cost;
    }
}
