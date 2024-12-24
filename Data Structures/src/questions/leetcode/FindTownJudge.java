package questions.leetcode;

public class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }

        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];

        for (int[] relation: trust) {
            int a = relation[0];
            int b = relation[1];

            outDegree[a]++;
            inDegree[b]++;
        }

        for (int i=1; i<=n; i++) {
            if (inDegree[i] == n - 1&& outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
