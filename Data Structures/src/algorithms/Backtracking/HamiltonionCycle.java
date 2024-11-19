package algorithms.Backtracking;

class HamiltonianCycle {

    private int numOfVertex;
    private int[] hamiltonianPath;

    HamiltonianCycle(int vertices) {
        this.numOfVertex = vertices;
        this.hamiltonianPath = new int[vertices];
    }

    public boolean findHamiltonianCycle(int[][] graph) {
        if (numOfVertex == 0 || graph == null) {
            System.out.println("Invalid or empty graph.");
            return false;
        }

        // Initialize the path
        for (int i = 0; i < numOfVertex; i++) {
            hamiltonianPath[i] = -1;
        }
        hamiltonianPath[0] = 0; // Start from vertex 0

        if (!findCycleRecursively(graph, 1)) {
            System.out.println("No Hamiltonian cycle found");
            return false;
        }

        printSolution();
        return true;
    }

    private boolean findCycleRecursively(int[][] graph, int position) {
        // Base case: Check if the path is a Hamiltonian cycle
        if (position == numOfVertex) {
            return graph[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1;
        }

        // Try all possible vertices for the next position
        for (int v = 1; v < numOfVertex; v++) {
            if (isValid(v, position, graph)) {
                hamiltonianPath[position] = v;

                // Recur to construct the remaining path
                if (findCycleRecursively(graph, position + 1)) {
                    return true;
                }

                // Backtrack
                hamiltonianPath[position] = -1;
            }
        }

        return false;
    }

    private boolean isValid(int vertex, int position, int[][] graph) {
        // Check adjacency
        if (graph[hamiltonianPath[position - 1]][vertex] == 0) {
            return false;
        }

        // Check if the vertex is already in the path
        for (int i = 0; i < position; i++) {
            if (hamiltonianPath[i] == vertex) {
                return false;
            }
        }

        return true;
    }

    private void printSolution() {
        for (int i = 0; i < numOfVertex; i++) {
            System.out.print(hamiltonianPath[i]);
            if (i < numOfVertex - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" -> " + hamiltonianPath[0]);
    }

    public static void main(String[] args) {
        // Adjacency matrix of the graph
        int[][] graph = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };

        HamiltonianCycle hc = new HamiltonianCycle(graph.length);
        hc.findHamiltonianCycle(graph);
    }
}