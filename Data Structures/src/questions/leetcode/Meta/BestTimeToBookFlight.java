package questions.leetcode.Meta;

public class BestTimeToBookFlight {
    public int findBestRoundtrip(int[] departing, int[] returning) {
        int minCost = Integer.MAX_VALUE;
        int departingCost = Integer.MAX_VALUE;

        for (int i=0; i<departing.length; i++) {
            departingCost = Math.min(departingCost, departing[i]);
            if (i + 1 < returning.length) {
                minCost = Math.min(minCost, departingCost + returning[i + 1]);
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[] departing = {1, 2, 3, 4};
        int[] returning = {4, 3, 2, 1};
        BestTimeToBookFlight o1 = new BestTimeToBookFlight();
        System.out.println(o1.findBestRoundtrip(departing, returning));
    }
}
