package algorithms.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MultiSourceBFS {

    public int rows;
    public int cols;
    public int[][] distance;
    public Queue<int[]> queue;

    public MultiSourceBFS(int[][] graph) {
        this.rows = graph.length;
        this.cols = graph[0].length;
        distance = new int[rows][cols];
        queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = Integer.MAX_VALUE;
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j}); // adding sources to the queue
                    distance[i][j] = 0; // distance of the white cell to a white cell is 0
                }
            }
        }
    }

    public int[][] distanceMatrix() {
        int[] xCoordinates = {1, -1, 0, 0};
        int[] yCoordinates = {0, 0, 1, -1};

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for (int i = 0; i < xCoordinates.length; i++) {
                int x = row + xCoordinates[i];
                int y = col + yCoordinates[i];

                if (x >=0 && x < rows && y >=0 && y < cols) {
                    if (distance[x][y] > distance[row][col] + 1) {
                        distance[x][y] = distance[row][col] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {

        // Example matrix with 0s and 1s
        int[][] matrix = {
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 0}
        };

        MultiSourceBFS bfs = new MultiSourceBFS(matrix);
        int[][] result = bfs.distanceMatrix();

        // Print the result matrix
        System.out.println("Updated Matrix with shortest distances to nearest 1:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
