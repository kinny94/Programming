package questions.leetcode;

public class FloodFill {
    public void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        int[][] offsets = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int n = image.length;
        int m = image[0].length;

        for (int[] offset: offsets) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];

            if (newRow < n && newRow >= 0 && newCol < m && newCol >= 0 && image[newRow][newCol] == oldColor) {
                image[newRow][newCol] = newColor;
                dfs(image, newRow, newCol, oldColor, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        } else {
            int temp = image[sr][sc];
            image[sr][sc] = color;
            dfs(image, sr, sc, temp, color);
            return image;
        }
    }
}
