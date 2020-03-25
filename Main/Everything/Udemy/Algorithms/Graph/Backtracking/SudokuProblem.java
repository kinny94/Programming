import javafx.scene.layout.Background;

class SudokuProblem {

    private static final int BOARD_SIZE = 9;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int BOX_SIZE = 3;

    private static int[][] sudokuTable;

    SudokuProblem(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
    }

    public void solveProblem() {
		if ( !solve(0, 0) ){
			System.out.println("No feasible solution found...");
		} else {	
			showResult();
		}
	}


    private void showResult() {
		
		for (int i = 0; i < Constants.BOARD_SIZE; ++i) {
			
			if(i % 3 == 0) System.out.println(" ");
			
			for (int j = 0; j < Constants.BOARD_SIZE; ++j) {
				
				if (j % 3 == 0) System.out.print(" ");
				System.out.print(sudokuTable[i][j]+" ");
			}
			
			System.out.println(" ");
		}	
	}

    private boolean solve(int rowIndex, int columnIndex) {
		
		if( rowIndex == BOARD_SIZE && ++columnIndex == BOARD_SIZE ){
			return true;
		}
		
		if( rowIndex == BOARD_SIZE){
			rowIndex=0;
		}
		
		if ( sudokuTable[rowIndex][columnIndex] != 0 ) { // skip filled cells
			return solve(rowIndex + 1, columnIndex);
		}

		for (int numbers = MIN_NUMBER; numbers <= MAX_NUMBER; ++numbers) {
			
			if ( valid(rowIndex, columnIndex, numbers) ) {
				
				sudokuTable[rowIndex][columnIndex] = numbers;
				
				if ( solve(rowIndex + 1, columnIndex) )
					return true;
			}
		}
		
		sudokuTable[rowIndex][columnIndex] = 0; // backtracking !!!
		
		return false;
	}

    private boolean valid(int columnIndex, int rowIndex, int actualNumber) {
		
		// if the given number is already in the row: the number cannot be part of the solution
		for (int i = 0; i < BOARD_SIZE; ++i) // check the rows
			if ( sudokuTable[i][rowIndex] == actualNumber )
				return false;

		// if the given number is already in the column: the number cannot be part of the solution
		for (int k = 0; k < BOARD_SIZE; ++k) 
			if ( sudokuTable[columnIndex][k] == actualNumber )
				return false;

		// if the given number is already in the box: the number cannot be part of the solution
		int boxRowOffset = (columnIndex / 3) * BOX_SIZE;
		int boxColumnOffset = (rowIndex / 3) * BOX_SIZE;
		
		for (int i = 0; i < BOX_SIZE; ++i)
			for (int j = 0; j < BOX_SIZE; ++j)
				if (actualNumber == sudokuTable[boxRowOffset + i][boxColumnOffset + j])
					return false;

		return true;
	}

    public static void main(String[] args) {
        int sudokuTable[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                		{5, 2, 0, 0, 0, 0, 0, 0, 0},
                		{0, 8, 7, 0, 0, 0, 0, 3, 1},
                		{0, 0, 3, 0, 1, 0, 0, 8, 0},
                		{9, 0, 0, 8, 6, 3, 0, 0, 5},
                		{0, 5, 0, 0, 9, 0, 6, 0, 0},
                		{1, 3, 0, 0, 0, 0, 2, 5, 0},
                		{0, 0, 0, 0, 0, 0, 0, 7, 4},
                		{0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuProblem sp = new SudokuProblem(sudokuTable);
        sp.solveProblem();
    }
}