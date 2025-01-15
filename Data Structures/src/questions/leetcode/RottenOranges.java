package questions.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int countFresh = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        if (countFresh == 0) {
            return 0;
        }

        int count = 0;
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] curr = queue.poll();
                for (int[] direction: directions) {
                    int newRow = curr[0] + direction[0];
                    int newCol = curr[1] + direction[1];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        countFresh--;
                    }
                }
            }
        }
        return countFresh == 0 ? count - 1 : -1;

    }
}
