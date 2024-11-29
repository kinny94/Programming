package practice.Nov28;

class ColoringProblem {

    private int[][] graph;
    private int[] colors;
    private int numOfVertices;
    private int numOfColors;

    public ColoringProblem(int[][] graph, int numOfColors) {
        this.graph = graph;
        this.numOfColors = numOfColors;
        this.numOfVertices = graph.length;
        this.colors = new int[graph.length];
    }

    public boolean solve() {
        for (int i=0; i<numOfVertices; i++) {
            this.colors[i] = 0;
        }

        if (findSolution(0)) {
            showResult();
            return true;
        }

        System.out.println("No solution found!");
        return false;
    }

    private boolean findSolution(int position) {
        // base case
        if (position == numOfVertices) {
            return true;
        }

        // try different colors
        for (int colorIndex=1; colorIndex<=numOfColors; colorIndex++) {
            if (isPositionValid(position, colorIndex)) {
                this.colors[position] = colorIndex;
                if (findSolution(position + 1)) {
                    return true;
                }
                this.colors[position] = 0;
            }
        }

        return false;
    }

    private boolean isPositionValid(int vertex, int color) {
        // check if the node is connected and any vertex has the same color
        for (int i=0; i<this.numOfVertices; i++) {
            if (graph[vertex][i] == 1 && this.colors[i] == color) {
                return false;
            }
        }
        return true;
    }

    public void showResult() {
        System.out.println("Color assignments for vertices...");
        for (int i=0; i<this.numOfVertices; i++) {
            System.out.println("Vertex " + i + " -> Color " + colors[i]) ;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };
        ColoringProblem coloringProblem = new ColoringProblem(graph, 3);
        coloringProblem.solve();
        int[][] graph2 = {
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0},
        };
        ColoringProblem coloringProblem2 = new ColoringProblem(graph2, 4);
        coloringProblem2.solve();
    }
}