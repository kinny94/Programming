package questions.leetcode;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0, p2 = numbers.length - 1;
        int[] arr = new int[2];
        for (int i=0; i<numbers.length; i++) {
            if (numbers[p1] + numbers[p2] > target) {
                p2--;
            } else if (numbers[p1] + numbers[p2] < target) {
                p1++;
            } else {
                arr[0] = p1 + 1;
                arr[1] = p2 + 1;
            }
        }
        return arr;
    }
}
