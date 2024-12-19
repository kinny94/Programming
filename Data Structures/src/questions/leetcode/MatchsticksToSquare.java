package questions.leetcode;

import java.util.Arrays;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int totalLength = Arrays.stream(matchsticks).sum();
        if (totalLength % 4 != 0) {
            return false;
        }

        int sideLength = totalLength / 4;
        Arrays.sort(matchsticks);
        reverseArray(matchsticks);// descending order

        int[] sides = new int[4];
        return backtrack(matchsticks, 0, sides, sideLength);
    }

    private boolean backtrack(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        for (int i=0; i<4; i++) {
            if (sides[i] + matchsticks[index] > target) {
                continue;
            }
            sides[i] += matchsticks[index];
            if (backtrack(matchsticks, index + 1, sides, target)) {
                return true;
            }
            sides[i] -= matchsticks[index];
        }
        return false;
    }

    private void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
