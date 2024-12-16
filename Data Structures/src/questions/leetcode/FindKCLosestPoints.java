package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKCLosestPoints {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> closestElement = new ArrayList<>();

        if (arr.length == k ){
            for (int num:  arr) {
                closestElement.add(num);
            }
            return closestElement;
        }

        if (x <= arr[0]) {
            for (int i=0; i<k; i++) {
                closestElement.add(arr[i]);
            }
            return closestElement;
        }

        if (x >= arr[arr.length - 1]) {
            for (int i=arr.length - k; i < arr.length; i++) {
                closestElement.add(arr[i]);
            }
            return closestElement;
        }

        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int firstClosest = left;
        int windowLeft = firstClosest - 1;
        int windowRight = windowLeft + 1;

        while ((windowRight - windowLeft  - 1) < k) {
            if (windowLeft == -1) {
                windowRight++;
                continue;
            }

            if (windowRight == arr.length || Math.abs(arr[windowLeft] - x) <= Math.abs(arr[windowRight] - x)) {
                windowLeft--;
            } else {
                windowRight++;
            }
        }

        for (int i=windowLeft + 1; i<windowRight; i++) {
            closestElement.add(arr[i]);
        }
        return closestElement;
    }
}
