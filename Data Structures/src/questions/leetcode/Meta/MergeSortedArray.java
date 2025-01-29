package questions.leetcode.Meta;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }

            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
        };
    }

    // if length is not given
    public static void merge(int[] a, int[] b) {
        int p1 = 0;

        while(p1 < a.length && a[p1] != 0) {
            p1++;
        }
        p1--;
        int p2 = b.length - 1;
        int p = a.length - 1;

        while(p >= 0) {
            if (p2 < 0) {
                break;
            }

            if (p1 >= 0 && a[p1] > b[p2]) {
                a[p] = a[p1];
                p1--;
            } else {
                a[p] = b[p2];
                p2--;
            }
            p--;
        }

        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
