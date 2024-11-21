package algorithms.Backtracking;

public class ColoringProblem {


    private int[][] graph;
    private int numberOfColors;
    private int numberOfVertices;
    private int colors[];

    ColoringProblem(int[][] graph, int numberOfColors) {
        this.graph = graph;
        this.numberOfColors = numberOfColors;
        this.numberOfVertices = graph.length;
        this.colors = new int[graph.length];
    }

    public boolean solve() {

        for (int i=0; i<this.numberOfVertices; i++) {
            this.colors[i] = 0;
        }

        if (findSolution(0)) {
            showResult();
            return true;
        }

        System.out.println("No Solution Found");
        return false;
    }

    public boolean findSolution(int vertex) {
        // base case
        if (vertex == this.numberOfVertices) {
            return true;
        }

        // try different color for this vertex
        for (int colorIndex=1; colorIndex<=numberOfColors; colorIndex++) {
            if (isPositionValid(vertex, colorIndex)) {
                this.colors[vertex] = colorIndex;

                // check for the next vertex recursively
                if (findSolution(vertex + 1)) {
                    return true;
                }

                // backtrack if its not possible
                this.colors[vertex] = 0;
            }
        }
        return false;
    }

    public boolean isPositionValid(int vertex, int color) {
        // check if the node is connected and any vertex has the same color
        for (int i=0; i<this.numberOfVertices; i++) {
            if (graph[vertex][i] == 1 && this.colors[i] == color) {
                return false;
            }
        }
        return true;
    }

    private void showResult() {
        System.out.println("Color assignments for vertices:");
        for (int i = 0; i < this.numberOfVertices; i++) {
            System.out.println("Vertex " + i + " -> Color " + colors[i]);
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
