package questions.leetcode;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];

        for (int i=0; i<result.length; i++) {
            result[i] = -1;
        }

        for (int col=0; col<grid[0].length; col++) {
            int currentCol = col;
            for (int row=0; row < grid.length; row++) {
                int nextColumn = currentCol + grid[row][currentCol];
                if (nextColumn < 0 || nextColumn > grid[0].length - 1 || grid[row][currentCol] != grid[row][nextColumn]) {
                    break;
                }

                if (row == grid.length - 1){
                    result[col] = nextColumn;
                }
                currentCol = nextColumn;
            }
        }
        return result;
    }
}
