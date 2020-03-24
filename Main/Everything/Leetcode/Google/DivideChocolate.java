class DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int K) {
        int left = 1; 
        int sum = 0;
        for (int i: sweetness) {
            sum += i;
        }
        System.out.println(sum);
        int right = sum/(K+1);
        System.out.println(right);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int cur = 0; 
            int cuts = 0;
            for (int i: sweetness) {
                if ((cur += i) >= mid) {
                    cur = 0;
                    if (++cuts > K) break;
                }
            }
            
            if (cuts > K) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}