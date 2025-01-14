package questions.leetcode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int low = 0;
        int high = nums1.length;
        int totalElements = nums1.length + nums2.length;
        while (low <= high) {
            int aleft = low + (high - low) / 2;
            int bleft = (totalElements + 1) / 2 - aleft;

            int alml = (aleft == 0) ? Integer.MIN_VALUE : nums1[aleft - 1];
            int al = (aleft == nums1.length) ? Integer.MAX_VALUE : nums1[aleft];
            int blml = (bleft == 0) ? Integer.MIN_VALUE : nums2[bleft - 1];
            int bl = (bleft == nums2.length) ? Integer.MAX_VALUE : nums2[bleft];
            // valid segregation
            if (alml <= bl && blml <= al) {
                double median = 0.0;

                if (totalElements % 2 == 0) {
                    int lmax = Math.max(alml, blml);
                    int rmin = Math.min(al, bl);
                    median = (lmax + rmin)/2.0;
                } else {
                    int lmax = Math.max(alml, blml);
                    median = lmax;
                }
                return median;
            } else if (alml > bl) {
                // there are more elements to be picked in left part nums2
                high = aleft - 1;

            } else if (blml > al) {
                // there are more elements to be picked in left part from nums1
                low = aleft + 1;
            }
        }
        return 0;
    }
}
