class WordSearch {
    
    public boolean exists(char[][] matrix, String word) {

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    if (dfs(matrix, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] matrix, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }

        if (i == -1 || j == -1 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != word.charAt(index)) {
            return false;
        }

         boolean found = dfs(matrix, i + 1, j, index + 1, word) ||
        dfs(matrix, i - 1, j, index + 1, word) ||
        dfs(matrix, i, j + 1, index + 1, word) ||
        dfs(matrix, i, j - 1, index + 1, word);
        
        return found;
    }
}