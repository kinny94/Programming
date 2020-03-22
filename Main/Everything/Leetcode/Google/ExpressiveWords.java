class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String w : words) {
            if (valid(w, S)) count++;
        }
        return count;
    }
    
    private boolean valid(String w, String S) {
        int n = S.length();
        int m = w.length();
        if (m > n) return false;
        
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            // System.out.println(w.charAt(i));
            // System.out.println(S.charAt(j));
            if (w.charAt(i) == S.charAt(j)) {
                int len1 = length(w, i);
                int len2 = length(S, j);
                if (len1 > len2) return false;
                if (len2 < 3 && len1 != len2) return false;
                i += len1;
                j += len2;
            } else return false;      
            
        }
        return i == m && j == n;
    }
    
    private int length(String S, int i) {
        int j = i;
        while (j < S.length() && S.charAt(j) == S.charAt(i)) j++;
        return j - i;
    }
}