package practice.Nov28;

// Its hamiltonion
public class HamiltonCycle {

    private int[] hamiltonPath;
    private int numOfVertices;

    public HamiltonCycle(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.hamiltonPath = new int[numOfVertices];
    }

    public boolean findHamiltonCycle(int[][] graph) {
        if (numOfVertices == 0 || graph == null) {
            System.out.println("Empty graph!");
            return false;
        }

        for (int i=0; i<numOfVertices; i++) {
            hamiltonPath[i] = -1;
        }
        hamiltonPath[0] = 0;

        if (!findRecursively(graph, 1)) {
            System.out.println("No cycles found!!");
            return false;
        } 

        printSolution();
        return true;
    }

    private boolean findRecursively(int[][] graph, int position) {
        // base case: check if the path is a hamiltonion cycle
        if (position == numOfVertices) {
            return graph[hamiltonPath[position - 1]][hamiltonPath[0]] == 1;
        }

        // try all possible vertices
        for (int v=1; v<numOfVertices; v++) {
            if (isPlaceValid(v, position, graph)) {
                hamiltonPath[position] = v;
            
                if (findRecursively(graph, position + 1)) {
                    return true;
                }

                hamiltonPath[position] = -1;
            }
        }
        return false;
    }

    private boolean isPlaceValid(int vertex, int position, int[][] graph) {
        // check adjacency
        if (graph[hamiltonPath[position - 1]][vertex] == 0) {
            return false;
        }

        // check if the vertex is already in the path
        for (int i=0; i<position; i++) {
            if (hamiltonPath[i] == vertex) {
                return false;
            }
        }

        return true;
    }

    private void printSolution() {
        for (int i = 0; i < numOfVertices; i++) {
            System.out.print(hamiltonPath[i]);
            if (i < numOfVertices - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" -> " + hamiltonPath[0]);
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

        HamiltonCycle hc = new HamiltonCycle(graph.length);
        hc.findHamiltonCycle(graph);
    }
    
}
