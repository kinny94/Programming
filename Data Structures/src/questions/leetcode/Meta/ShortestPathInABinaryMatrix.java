package questions.leetcode.Meta;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInABinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        int[][] directions = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},         {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int pathLength = curr[2];

            if (row == n-1 && col == n-1) {
                return pathLength;
            }

            for (int[] direction: directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newCol < n && newRow < n && newRow >= 0 && newCol >= 0 && grid[newRow][newCol] != 1) {
                    queue.add(new int[]{newRow, newCol, pathLength + 1});
                    grid[newRow][newCol] = 1;
                }
            }
        }
        return -1;
    }
}
