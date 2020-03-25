class RepeatedString {
    
    static long repeatedString(String s, long n) {

        int i=0;
        long count = 0;
    
        for(i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a')
                count++;
        }
    
        long div = n/s.length();
        long reminder = n%s.length();
    
        count = div*count;
    
        for(i=0; i<reminder; i++){
            if(s.charAt(i) == 'a')
                count++;
        }
    
        return count;
    }

    public static int getCharInString(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

    
    public static void main(String[] args) {
        RepeatedString obj = new RepeatedString();
        System.out.println(obj.repeatedString("aba", 13));
    }
}