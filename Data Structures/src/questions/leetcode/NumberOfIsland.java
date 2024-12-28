package questions.leetcode;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count=0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        int[][] offsets = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] offset: offsets) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];
            dfs(grid, newRow, newCol);
        }
    }
}
