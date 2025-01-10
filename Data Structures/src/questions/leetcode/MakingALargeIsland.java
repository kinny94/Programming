package questions.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int islandIds = -1;
        Map<Integer, Integer> islandArea = new HashMap<>();

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(i, j, grid, islandIds);
                    islandArea.put(islandIds, size);
                    islandIds--;
                }
            }
        }

        int maxIsland = 0;
        for (int size : islandArea.values()) {
            maxIsland = Math.max(maxIsland, size);
        }

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborIslands = new HashSet<>();
                    for (int[] direction: directions) {
                        int newRow = direction[0] + i;
                        int newCol = direction[1] + j;
                        if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] < 0)  {
                            neighborIslands.add(grid[newRow][newCol]);
                        }
                    }

                    int newSize = 1;
                    for (int id: neighborIslands) {
                        newSize += islandArea.get(id);
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }
        return maxIsland;
    }

    public int dfs(int row, int col, int[][] grid, int islandId) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = islandId;
        int size = 1;
        for(int[] direction: directions) {
            int newRow = direction[0] + row;
            int newCol = direction[1] + col;
            size += dfs(newRow, newCol, grid, islandId);
        }
        return size;
    }
}
