class FindMaximumGold {
    private final static int[] movesX = new int[]{1, -1, 0, 0};
    private final static int[] movesY = new int[]{0, 0, 1, -1};
    
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxGold = 0;
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                maxGold = Math.max(maxGold, findMaxGold(grid, r, c));

        return maxGold;
    }
    
    private int findMaxGold(int grid[][], int row, int column) {
        if (row < 0 || row >= grid.length) {
            return 0;
        }  
        
        if (column < 0 || column >= grid[0].length) {
            return 0;
        }
        
        if (grid[row][column] == 0) {
            return 0;
        }
        
        int startingPoint = grid[row][column];
        int maxGold = 0;
        grid[row][column] = 0; // marked as visited;
        
        for (int i=0; i<4; i++) {
            maxGold = Math.max(maxGold, findMaxGold(grid, movesX[i] + row, movesY[i] + column));
        }
                               
        grid[row][column] = startingPoint; // backtrack
        return maxGold + startingPoint;
    }
}