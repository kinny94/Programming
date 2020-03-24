class NumOfSubmatixThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i=0; i<m; i++) {
            for (int j=1; j<n; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                counter.clear();
                counter.put(0, 1);
                int current = 0;
                for (int k=0; k<m; k++) {
                    current += matrix[k][j] - (i > 0 ? matrix[k][i-1] : 0);
                    result += counter.getOrDefault(current - target, 0);
                    counter.put(current, counter.getOrDefault(current, 0) + 1);
                }
            }
        }
        
        return result;
    }
}