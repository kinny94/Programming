package questions.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildingsWithOceanView {


    // right side ocean
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int maxHeight = heights[heights.length - 1];
        list.add(heights.length - 1);
        for (int i=heights.length - 2; i>=0; i--) {
            if (heights[i] > maxHeight) {
                list.add(i);
                maxHeight = heights[i];
            }
        }
        int[] result = new int[list.size()];
        int j = 0;
        for (int i=list.size() - 1; i>=0; i--) {
            result[j] = list.get(i);
            j++;
        }
        return result;
    }

    // both side ocean
    public List<Integer> findBuildingsBothSideOcean(int[] heights) {
        int n = heights.length;
        if (n == 1) {
            return new ArrayList<Integer>();
        }

        int left = 0, right = n - 1;
        List<Integer> leftview = new ArrayList<>();
        List<Integer> rightview = new ArrayList<>();
        int left_max = heights[left];
        int right_max = heights[right];
        while (left < right) {
            if (left_max < right_max) {
                left++;
                if (heights[left] > left_max ) {
                    leftview.add(left);
                    left_max = heights[left];
                }
            } else {
                right--;
                if (heights[right] > right_max ) {
                    rightview.add(right);
                    right_max = heights[right];
                }
            }
        }
        // joining for sequenced answer
        Collections.reverse(rightview);
        // join the two list
        leftview.addAll(rightview);
        return leftview;

    }
}
