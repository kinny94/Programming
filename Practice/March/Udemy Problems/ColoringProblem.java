class ColoringProblem {
    
    private int numOfVertices;
    private int numOfColors;
    private int[] colors;
    private int[][] adjacencyMatrix;

    ColoringProblem(int[][] adjacencyMatrix, int numOfColors) {
        this.numOfColors = numOfColors;
        this.adjacencyMatrix = adjacencyMatrix;
        this.numOfVertices = adjacencyMatrix.length;
        this.colors = new int[numOfVertices];
    }

    public void solve() {
        if (solveProblem(0)) {
            showResult();
        } else {
            System.out.println("There are no feasible solution...");
        }
    }

    private void showResult() {
        for (int i=0; i<numOfVertices; i++) {
            System.out.println("Node " + (i+1) + " has color index: " + colors[i]);
        }
    }

    private boolean solveProblem(int  nodeIndex) {
        if (nodeIndex == numOfVertices) {
            return true;
        }

        for (int colorIndex=1; colorIndex<= numOfColors; colorIndex++) {
            if (isColorValid(nodeIndex, colorIndex)) {
                colors[nodeIndex] = colorIndex;

                if (solveProblem(nodeIndex + 1)) {
                    return true;
                }

                // backtrack
            }
        }
        return false;
    }

    private boolean isColorValid(int nodeIndex, int colorIndex) {
        for (int i=0; i<numOfVertices; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1 && colorIndex == colors[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 1, 0}
        };
        int numOfColors= 3;


        ColoringProblem cp = new ColoringProblem(matrix, numOfColors);
        cp.solve();
    }
}