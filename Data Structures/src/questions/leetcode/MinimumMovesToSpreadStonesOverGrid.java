package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumMovesToSpreadStonesOverGrid {
    private int minMoves = 0;

    public int minimumMoves(int[][] grid) {
        List<int[]> zeros = new ArrayList<>();
        List<int[]> extras = new ArrayList<>();
        minMoves = Integer.MAX_VALUE;
        int totalStones = 0;

        for (int[] row: grid) {
            for (int cell: row) {
                totalStones += cell;
            }
        }

        if (totalStones != 9) {
            return -1;
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (grid[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                } else if (grid[i][j] > 1) {
                    extras.add(new int[]{i, j, grid[i][j] - 1});
                }
            }
        }

        if (zeros.size() == 0) {
            return 0;
        }

        solve(zeros, extras, 0, 0);
        return minMoves;
    }

    private void solve(List<int[]> zeros, List<int[]> extras, int i, int count) {
        if (i >= zeros.size()) {
            minMoves = Math.min(minMoves, count);
            return;
        }
        for (int k = 0; k < extras.size(); k++) {
            if (extras.get(k)[2] != 0) {
                extras.get(k)[2]--;
                solve(zeros, extras, i + 1, Math.abs(extras.get(k)[0] - zeros.get(i)[0]) + Math.abs(extras.get(k)[1] - zeros.get(i)[1]) + count);
                extras.get(k)[2]++;
            }
        }
    }
}
