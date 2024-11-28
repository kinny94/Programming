package practice.Nov18;

public class HamiltonionCycle {

    private int numberOfVertices;
    private int[][] graph;
    private int[] hamiltonianPath;

    HamiltonionCycle(int[][] graph) {
        this.numberOfVertices = graph.length;
        this.graph = graph;
        this.hamiltonianPath = new int[graph.length];
    }

    public boolean solve() {
        // initialize the path
        for (int i=0; i<this.hamiltonianPath.length; i++) {
            this.hamiltonianPath[i] = -1;
        }

        // start the path from vertex 0
        this.hamiltonianPath[0] = 0;

        if (!findSolution(1)) {
            System.out.println("Hamiltonion cycle does not exists");
            return false;
        }

        printSolution();
        return true;

    }

    public void printSolution() {
        for (int i=0; i<this.hamiltonianPath.length; i++) {
            System.out.print(this.hamiltonianPath[i] + " ");
        }
        // since last item is connected to the first one
        System.out.print(this.hamiltonianPath[0]);
    }

    private boolean isSafe(int vertex, int position) {
        if (this.graph[hamiltonianPath[position - 1]][vertex] == 0) {
            return false;   
        }


        for (int i=1; i<position; i++) {
            // check if the vertex is adjacent to the previously added vertex
            if (hamiltonianPath[i] == vertex) {
                return false;
            }
        }

        return true;
    }

    public boolean findSolution(int position) {
        // check if I have reached the last element
        if (position == this.numberOfVertices) {
            // check If the the last element is connected to first one
            return this.graph[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1;
        }

        // try all different vertices that are connected
        for (int vertex=1; vertex<numberOfVertices; vertex++) {
            if (isSafe(vertex, position)) {
                hamiltonianPath[position] = vertex;

                // recur to construct the next path
                if (findSolution(position + 1)) {
                    return true;
                }

                // backtrack
                hamiltonianPath[position] = -1;
            }
        } 
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };

        HamiltonionCycle hc = new HamiltonionCycle(graph);
        hc.solve();
        System.out.println();
        System.out.println();
        int[][] graph2 = 
        {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };
        HamiltonionCycle hc2 = new HamiltonionCycle(graph2);
        hc2.solve();
        System.out.println();
        System.out.println();
        int[][] graph3 = 
        {
            {0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 1},
            {0, 0, 1, 1, 0, 1},
            {1, 0, 0, 1, 1, 0}
        };
        HamiltonionCycle hc3 = new HamiltonionCycle(graph3);
        hc3.solve();

    }
    
}
