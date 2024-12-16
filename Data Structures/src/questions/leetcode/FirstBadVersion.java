package questions.leetcode;

public class FirstBadVersion {
    public static boolean isBadVersion(int v){ // isBadVersion() is the API function that returns true or false depending upon whether the provided version ID is bad or not
        // only dummy
        return true;
    }
//-------------------------------------------------

    public static int[] firstBadVersion(int n) {
        int[] result = new int[2];
        int low = 1;
        int high = n;
        int calls = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (!isBadVersion(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            calls++;
        }

        result[0] = low;
        result[1] = calls;
        return result;
    }
}
