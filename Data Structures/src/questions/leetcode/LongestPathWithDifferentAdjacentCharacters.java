package questions.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LongestPathWithDifferentAdjacentCharacters {
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        int[] inDegree = new int[n];

        for (int i=1; i<n; i++) {
            inDegree[parent[i]]++;
        }

        int[][] longestChain = new int[n][2];
        int longestPathLength = 1;
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<n; i++) {
            if (inDegree[i] == 0) {
                longestChain[i][0] = 1;
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            int par = parent[currentNode];
            if (par != -1) {
                int longestChainFromCurrent = longestChain[currentNode][0];
                if (s.charAt(currentNode) != s.charAt(par)) {
                    if (longestChainFromCurrent > longestChain[par][0]) {
                        longestChain[par][1] = longestChain[par][0];
                        longestChain[par][0] = longestChainFromCurrent;
                    } else if (longestChainFromCurrent > longestChain[par][1]) {
                        longestChain[par][1] = longestChainFromCurrent;
                    }
                }

                longestPathLength = Math.max(longestPathLength, longestChain[par][0] + longestChain[par][1] + 1);
                inDegree[par]--;
                if (inDegree[par] == 0) {
                    longestChain[par][0]++;
                    queue.offer(par);
                }
            }
        }
        return longestPathLength;
    }
}
