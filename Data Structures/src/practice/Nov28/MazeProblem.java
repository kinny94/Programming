package practice.Nov28;

public class MazeProblem {

    private int[][] maze;
    private int[][] solution;
    private int mazeSize;

    MazeProblem(int[][] maze) {
        this.maze = maze;
        this.mazeSize = maze.length;
        this.solution = new int[mazeSize][mazeSize];
    }


    public void solve() {
        if (findSolution(0, 0)) {
            showSolution();
        } else {
            System.out.println("There is no solution!");
        }
    }

    public boolean findSolution(int rowIndex, int colIndex) {
        if (isFinished(rowIndex, colIndex)) {
            return true;
        }

        if (isValid(rowIndex, colIndex + 1)) {
            solution[rowIndex][colIndex] = 1;

              // Going right - go forward in the horizontal direction
              if (findSolution(rowIndex, colIndex + 1)) {
                return true;
            }

            // Going down - go downward in the vertical direction
            if (findSolution(rowIndex + 1, colIndex)) {
                return true;
            }

            // backtracking
            solution[rowIndex][colIndex] = 0;
        }
        return false;
    }

    private boolean isValid(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= mazeSize) {
            return false;
        }
        if (colIndex < 0 || colIndex >= mazeSize) {
            return false;
        }

        return maze[rowIndex][colIndex] != 0;
    }

    private boolean isFinished(int rowIndex, int colIndex) {
        // reached end
        if (rowIndex == mazeSize - 1 && colIndex == mazeSize - 1) {
             solution[rowIndex][colIndex] = 1;
             return true;
        }
        return false;
    }


    private void showSolution() {
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                if (solution[i][j] == 1) {
                    System.out.print(" S ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {0, 0, 1, 1},
            {1, 0, 1, 1}
        };
        MazeProblem mazeProblem = new MazeProblem(maze);
        mazeProblem.solve(); 
    }
}
