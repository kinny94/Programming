// obstacle = 0, pathpossible = 1

// s will represent the path to get out of the maze
class MazeProblem {

    private int[][] mazeTable;
    private int[][] solutionTable;
    private int mazeSize;


    MazeProblem(int[][] maze) {
        this.mazeTable = maze;
        this.mazeSize = maze.length;
        this.solutionTable = new int[mazeSize][mazeSize];
    } 

    private void showResults(){
        for (int i=0; i<mazeSize; i++) {
            for (int j=0; j<mazeSize; j++) {
                if (solutionTable[i][j] == 1) {
                    System.out.print(" S ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public void solve() {
        if (solveMaze(0,0)) {
            showResults();
        } else {
            System.out.println("No solution is possible");
        }
    }

    private boolean solveMaze(int x, int y) {
        if (isFinished(x, y)) {
            return true;
        }   

        if (isValid(x, y)) {
            solutionTable[x][y] = 1;

            // go to the right
            if (solveMaze(x+1, y)) {
                return true;
            }

            // go down
            if (solveMaze(x, y+1)) {
                return true;
            }       

            // backtrack
            solutionTable[x][y] = 0;
        }

        return false;
    }

    private boolean isFinished(int x, int y) {
        if (x == mazeSize-1 && y == mazeSize-1) {
            solutionTable[x][y] = 1;
            return true;
        }     

        return false;
    }

    private boolean isValid(int x, int y) {
        if (x < 0 || x >= mazeSize) {
            return false;
        }

        if (y < 0 || y >= mazeSize) {
            return false;
        }

        if (mazeTable[x][y] != 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1}
        } ;
        MazeProblem mp = new MazeProblem(maze);
        mp.solve();

    }
    
}