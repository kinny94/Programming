class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder mainString = new StringBuilder(A);
        boolean  matchFound = false;
        int i=1;
        for(; mainString.length() < (B.length() + 2 * A.length()); i++ ){
            if( mainString.toString().contains(B)){
                matchFound = true;
                return i;
            }else{
                mainString.append( A );
            }  
        }
        
        if( !matchFound ){
            return -1;
        }

        return i;
    }

    public static void main(String[] args) {
        
        RepeatedStringMatch obj = new RepeatedStringMatch();
        System.out.println(obj.repeatedStringMatch("abcd", "cdabcdab"));
    }
}