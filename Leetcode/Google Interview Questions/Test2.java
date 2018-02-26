class Test2 {
    public int solution(int[] P, int K) {
        int[] days = new int[P.length];
        for( int i=0; i<P.length; i++){
            days[P[i] - 1] = i + 1;
        }
        
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = K + 1;
        
        search: while(right < days.length ){
            for( int i =left+1; i<right; ++i){
                if(days[i] < days[left] || days[i] < days[right]){
                    left = i;
                    right = i + K + 1;
                    continue search;
                }
            }
            
            ans = Math.min( ans, Math.max(days[left], days[right]));
            left = right;
            right = left + K + 1;
        }
        
        return ans < Integer.MAX_VALUE ? ans : -1;
    }

    public static void main(String[] args) {
        Test2 obj = new Test2();
        int a[] = {3, 1, 5, 4, 2};
        System.out.println(obj.solution(a, 1));
    }
}