package algorithms.Graph.ShortestPath;

public class FloydWarshall {

    public static void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] distance = new int[n][n];

        // Initialize the  matrix with the given length
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = graph[i][j];
            }
        }

        // Floyd Warshall Algo
        for (int k=0; k<n; k++) { // intermediate vertex
            for (int i = 0; i < n; i++) { // source vertex
                for (int j = 0; j < n; j++) { // destination vertex
                    if (
                        distance[i][k] != Integer.MAX_VALUE &&
                        distance[k][j] != Integer.MAX_VALUE &&
                        distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int i = 0; i < n; i++) {
            if (distance[i][i] < 0) {
                System.out.println("Negative weight cycle detected involving vertex " + i);
                return;
            }
        }

        // print solution
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distance[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {2, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 7, 0, 1},
                {6, 9, Integer.MAX_VALUE, 0}
        };
        // Run the Floyd-Warshall algorithm
        floydWarshall(graph);

        int[][] graph2 = {
                {0, Integer.MAX_VALUE, -2, Integer.MAX_VALUE},
                {4, 0, 3, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 2},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, 0}
        };
        floydWarshall(graph2);

        int[][] graphWithNegativeCycle = {
                {0, 1, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, -1},
                {-1, Integer.MAX_VALUE, 0}
        };
        floydWarshall(graphWithNegativeCycle);
    }
}
