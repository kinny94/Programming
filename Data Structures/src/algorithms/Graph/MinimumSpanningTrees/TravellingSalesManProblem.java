package algorithms.Graph.MinimumSpanningTrees;

import java.util.Arrays;

public class TravellingSalesManProblem {

    public int[][] graph;
    public int numberOfCities;
    public int[][] dp;

    public TravellingSalesManProblem(int[][] graph) {
        this.graph = graph;
        this.numberOfCities = graph.length;
        this.dp = new int[1<<numberOfCities][numberOfCities]; // n + 1 to store up to n cities visited
        // fill the array with -1
        // Fill each row with a value
        for (int i = 0; i < 1<<numberOfCities; i++) {
            Arrays.fill(dp[i], -1);  // Fill each row with value 10
        }
    }

    public int tsp(int[][] graph, int setOfCities, int city, int numberOfCities) {
        // base case
        if (setOfCities == (1<<numberOfCities) - 1) { // N = 4, 2^4 - 1 which is (1 << 4) - 1 - This means we have covered all the cities
            // return the cost from the city to the original
            return graph[city][0];
        }

        if (dp[setOfCities][city] != -1) {
            return dp[setOfCities][city];
        }

        int ans = Integer.MAX_VALUE;

        // try all possible options
        for (int choice = 0; choice < numberOfCities; choice++) {
            // need to check if the city is visited or not
            if ((setOfCities & (1 << choice)) == 0) { // consider setOfCities as binary and we want to check if the ith bit is 1 or 0
                // this city is not visited
                int changedSetCityBit = setOfCities | (1 << choice);
                int subProblem = graph[city][choice] + tsp(graph, changedSetCityBit, choice, numberOfCities);
                ans = Math.min(ans, subProblem);
            }
        }
        dp[setOfCities][city] = ans;
        return ans;
    }


    public static void main(String[] args) {
        // Example graph (cost matrix)
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        // Create an instance of the TravellingSalesManProblem class
        TravellingSalesManProblem tspSolver = new TravellingSalesManProblem(graph);

        // Call tsp method starting from city 0, and no cities visited yet (setOfCities = 1 << 0)
        int result = tspSolver.tsp(graph, 1, 0, tspSolver.numberOfCities);

        // Output the result
        System.out.println("Minimum cost to visit all cities: " + result);
    }
}
