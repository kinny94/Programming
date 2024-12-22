package questions.leetcode;

public class SmallestRectangleEnclosingBlackPixel {
    public int minArea(char[][] image, int x, int y) {
        int left = binarySearch(0, y, mid -> containsBlackPixelInColumn(image, mid));
        int right = binarySearch(y + 1, image[0].length, mid -> !containsBlackPixelInColumn(image, mid)) - 1;
        int top = binarySearch(0, x, mid -> containsBlackPixelInRow(image, mid));
        int bottom = binarySearch(x + 1, image.length, mid -> !containsBlackPixelInRow(image, mid)) - 1;
        return (right - left + 1) * (bottom - top + 1);
    }

    private static boolean containsBlackPixelInColumn(char[][] image, int mid) {
        for (char[] chars: image) {
            if (chars[mid] == '1') {
                return true;
            }
        }
        return false;
    }

    private static boolean containsBlackPixelInRow(char[][] image, int mid) {
        for (char c: image[mid]) {
            if (c == '1') {
                return true;
            }
        }
        return false;
    }

    private static int binarySearch(int low, int high, java.util.function.Predicate<Integer> checkFunc) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (checkFunc.test(mid)) {
                high = mid;
            } else{
                low = mid + 1;
            }
        }
        return low;
    }
}
