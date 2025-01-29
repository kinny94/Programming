package questions.leetcode.Meta;

public class MaximumSwap {
    public int maximumSwap(int num) {
        char maxValue = '0';
        int maxIndex = -1;
        int swap1 = -1;
        int swap2 = -1;
        char[] arr = Integer.toString(num).toCharArray();

        for (int i=arr.length - 1; i>=0; i--) {
            if (arr[i] > maxValue) {
                maxIndex = i;
                maxValue = arr[i];
            } else if (maxIndex != -1 && arr[i] < arr[maxIndex]) {
                swap1 = i;
                swap2 = maxIndex;
            }
        }

        if (swap1 != -1 && swap2 != -1) {
            char temp = arr[swap1];
            arr[swap1] = arr[swap2];
            arr[swap2] = temp;
        }

        return Integer.parseInt(new String(arr));
    }
}
