class NQueens {
    
    int[][] chesssboard;
    int numOfQueens;

    NQueens(int numOfQueens) {
        this.numOfQueens = numOfQueens;
        this.chesssboard = new int[numOfQueens][numOfQueens];
    }

    public void solve() {
        if (setQueens(0)) {
            printsolution();
        } else {
            System.out.println("There is no feasible solution...");
        }
    }

    private boolean setQueens(int columnIndex) {
        
        if (columnIndex == numOfQueens) {
            return true;
        }

        for (int rowIndex=0; rowIndex<numOfQueens; rowIndex++) {
            if (isStepValid(rowIndex, columnIndex)) {
                
                chesssboard[rowIndex][columnIndex] = 1;

                if (setQueens(columnIndex+1)) {
                    return true;
                }
    
                //backtrack;
                chesssboard[rowIndex][columnIndex] = 0;
            }
        }

        return false;
    }

    public void printsolution() {
        for (int i=0; i<numOfQueens; i++) {
            for (int j=0; j<numOfQueens; j++) {
                if (chesssboard[i][j] == 0) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" Q ");
                }
            }
            System.out.println();
        }
    }

    private boolean isStepValid(int rowIndex, int colIndex) {
		
		for(int i=0;i<colIndex;i++)
			if( chesssboard[rowIndex][i] == 1)
				return false;
		
		for(int i=rowIndex, j=colIndex;i>=0 && j>=0;i--,j--) {
			if( chesssboard[i][j] == 1 ) 
				return false;
		}
		
		for(int i=rowIndex, j=colIndex;i<chesssboard.length && j>=0;i++,j--) {
			if( chesssboard[i][j] == 1)
				return false;
		}
		
		return true;
	}

    public static void main(String[] args) {
        NQueens problem = new NQueens(4);   
        problem.solve();
    }
}