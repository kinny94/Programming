package questions.leetcode;

import java.util.*;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<String> visited = new HashSet<>();
        Map<String, Integer> uniqueIslands = new HashMap<>();

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited.contains(i + "," + j)) {
                    List<int[]> path = new ArrayList<>();
                    dfs(grid, i, j, i, j, path, visited);
                    StringBuilder pathKey = new StringBuilder();
                    for (int[] pos: path) {
                        pathKey.append(pos[0]).append(",").append(pos[1]).append(";");
                    }
                    uniqueIslands.put(pathKey.toString(), uniqueIslands.getOrDefault(pathKey.toString(), 0) + 1);
                }
            }
        }
        return uniqueIslands.size();
    }

    public void dfs(int[][] grid, int row, int col, int rowOrigin, int colOrigin, List<int[]> path, Set<String> visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >=grid[0].length || grid[row][col] == 0 || visited.contains(row + "," + col)) {
            return;
        }
        visited.add(row + "," + col);
        path.add(new int[]{row - rowOrigin, col - colOrigin});

        int[][] offsets = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] offset: offsets) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];
            dfs(grid, newRow, newCol, rowOrigin, colOrigin, path, visited);
        }
    }
}
