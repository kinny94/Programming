package questions.leetcode;

public class CountNegativeNumbersInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        int currentIndex = n - 1;

        for (int[] row: grid) {
            while(currentIndex >= 0 && row[currentIndex] < 0) {
                currentIndex--;
            }
            count = count + (n - (currentIndex + 1));
        }
        return count;
    }
}
