package practice.Dec1;

public class FloydWarshall {
    public static void floydWarshallSp(int[][]  graph) {
        int[][] distances = new int[graph.length][graph.length];

        // Initialize the  matrix with the given length
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                distances[i][j] = graph[i][j];
            }
        }
        
        // Floyd Warshall Algo
        for (int k=0; k < graph.length; k++) { // intermediate vertex
            for (int i = 0; i < graph.length; i++) { // source vertex
                for (int j = 0; j < graph.length; j++) { // destination vertex
                    if (
                        distances[i][k] != Integer.MAX_VALUE &&
                        distances[k][j] != Integer.MAX_VALUE &&
                        distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
        
        // Check for negative weight cycles
        for (int i = 0; i < graph.length; i++) {
            if (distances[i][i] < 0) {
                System.out.println("Negative weight cycle detected involving vertex " + i);
                return;
            }
        }
        
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (distances[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distances[i][j] + "   ");
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
        floydWarshallSp(graph);
        
        int[][] graph2 = {
            {0, Integer.MAX_VALUE, -2, Integer.MAX_VALUE},
            {4, 0, 3, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 2},
            {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, 0}
        };
        floydWarshallSp(graph2);
        
        int[][] graphWithNegativeCycle = {
            {0, 1, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 0, -1},
            {-1, Integer.MAX_VALUE, 0}
        };
        floydWarshallSp(graphWithNegativeCycle);        
    }
}
