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

    // Iterating allowed only from left - Pop all the elments on the left side where the height is less than the current
    public int[] findBuildingsLeftSideIteration(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();

        for (int current = 0; current < n; ++current) {
            // If the current building is taller,
            // it will block the shorter building's ocean view to its left.
            // So we pop all the shorter buildings that have been added before.
            while (!list.isEmpty() && heights[list.get(list.size() - 1)] <= heights[current]) {
                list.remove(list.size() - 1);
            }
            list.add(current);
        }

        // Push elements from list to answer array.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }

        return answer;
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
