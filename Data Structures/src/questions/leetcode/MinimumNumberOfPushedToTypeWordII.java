package questions.leetcode;

public class MinimumNumberOfPushedToTypeWordII {
    public static int minimumPushes(String word) {
        int[] frequencies = new int[26];

        for (char c : word.toCharArray()) {
            frequencies[c - 'a']++;
        }

        descendingSort(frequencies);

        int pushes = 0;

        for (int i = 0; i < 26; i++) {
            if (frequencies[i] == 0)
                break;
            pushes += (i / 8 + 1) * frequencies[i];
        }

        return pushes;
    }

    private static void descendingSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }

}
