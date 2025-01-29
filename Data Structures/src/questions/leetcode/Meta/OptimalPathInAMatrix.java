package questions.leetcode.Meta;

import java.util.*;

public class OptimalPathInAMatrix {
    public List<List<Integer>> shortestPathInMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // If starting or ending points are blocked, return invalid case
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return new ArrayList<>();
        }

        // Directions for moving up, down, left, and right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS setup
        Queue<List<Integer>> queue = new LinkedList<>();
        Queue<List<List<Integer>>> paths = new LinkedList<>();

        queue.add(Arrays.asList(0, 0)); // Starting point
        paths.add(new ArrayList<>(List.of(Arrays.asList(0, 0)))); // Initialize path for start
        grid[0][0] = 1; // Mark as visited

        while (!queue.isEmpty()) {
            List<Integer> curr = queue.poll();
            List<List<Integer>> currPath = paths.poll();

            int x = curr.get(0);
            int y = curr.get(1);

            // If we've reached the bottom-right corner, return the path
            if (x == m - 1 && y == n - 1) {
                return currPath;
            }

            // Explore all four possible directions
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // Check if the new position is valid and not visited
                if (newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] == 0) {
                    grid[newX][newY] = 1; // Mark as visited
                    queue.add(Arrays.asList(newX, newY));

                    // Add the new position to the current path
                    List<List<Integer>> newPath = new ArrayList<>(currPath);
                    newPath.add(Arrays.asList(newX, newY));
                    paths.add(newPath);
                }
            }
        }

        // If the loop ends without finding a valid path, return invalid case
        return new ArrayList<>();
    }
}
