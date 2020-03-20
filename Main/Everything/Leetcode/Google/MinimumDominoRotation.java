class MinimumDominoRotation {
    public int minDominoRotations(int[] A, int[] B) {

        int res1 = helper(A, B);        
        int res2 = helper(B, A);
        
        if(res1 == -1 && res2 == -1) return -1;
        
        if(res1==-1){
            return res2;
        }else if(res2==-1){
            return res1;
        }else{
            return Math.min(res1, res2);
        }
    }
    
    private int helper(int[] A, int[] B){
        int val = A[0];
        
        int countOfDiff = 0;
        int countOfSameVal = 0;
        
        for(int i=1; i<A.length; i++){
            
            if(A[i]==B[i]){
                countOfSameVal++;
            }
            
            if(A[i]==val){
                continue;
            }
            
            if(B[i]==val){
                countOfDiff++;
                continue;
            }
            
            return -1;
        }
        
        return Math.min(countOfDiff, A.length -countOfSameVal - countOfDiff);
    }
}