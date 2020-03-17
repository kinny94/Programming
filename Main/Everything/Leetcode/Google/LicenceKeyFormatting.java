class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        
        StringBuilder s =  new StringBuilder("");
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) != '-') {
                s.append(S.charAt(i));
            }
        }
        
        System.out.println(s);
        
        
        int remainder = s.length() % K;
        
        StringBuilder result = new StringBuilder("");
        System.out.println(remainder);
        
        if (remainder != 0) {
            for (int i=0; i<remainder; i++) {
                result.append(s.charAt(i));
            }
            
            if (remainder != s.length()) {
                result.append('-');   
            }
        }
        
        System.out.println(result);
        
        int counter = 0;
        for (int i=remainder; i<s.length(); i++) {
            if (counter == K) {
                counter = 0;
                result.append('-');
            }
            result.append(s.charAt(i));
            counter++;
        }
        
        return result.toString().toUpperCase();
        
    }
}