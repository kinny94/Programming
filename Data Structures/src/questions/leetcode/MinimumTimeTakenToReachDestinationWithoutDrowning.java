package questions.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumTimeTakenToReachDestinationWithoutDrowning {
    public int minimumSeconds(List<List<String>> land) {
        int m = land.size();
        int n = land.get(0).size();
        Queue<int[]> moves = new LinkedList<>();
        Queue<int[]> flood = new LinkedList<>();
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int seconds = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (land.get(i).get(j).equals("S")) {
                    moves.add(new int[]{i, j});
                }

                if (land.get(i).get(j).equals("*")) {
                    flood.add(new int[]{i, j});
                }
            }
        }

        while(!moves.isEmpty()) {
            int spread = flood.size();
            int move = moves.size();

            for (int i=0; i<spread; i++) {
                int[] floodPos = flood.poll();
                int floodX = floodPos[0];
                int floodY = floodPos[1];

                for (int[] direction: directions) {
                    int newX = floodX + direction[0];
                    int newY = floodY + direction[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && land.get(newX).get(newY).equals(".")) {
                        land.get(newX).set(newY, "*");
                        flood.add(new int[]{newX, newY});
                    }
                }
            }

            for (int i=0; i<move; i++) {
                int[] movePos = moves.poll();
                int moveX = movePos[0];
                int moveY = movePos[1];

                if (land.get(moveX).get(moveY).equals("D")) {
                    return seconds;
                }

                for (int[] direction: directions) {
                    int newX = direction[0] + moveX;
                    int newY = direction[1] + moveY;
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n &&  (land.get(newX).get(newY).equals(".") || land.get(newX).get(newY).equals("D"))) {
                        if (!land.get(newX).get(newY).equals("D")) {
                            land.get(newX).set(newY, "*");
                        }
                        moves.add(new int[]{newX, newY});
                    }
                }
            }
            seconds++;
        }

        return -1;
    }
}
