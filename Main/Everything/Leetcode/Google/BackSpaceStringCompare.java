class BackSpaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack();
        
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) != '#') {
                s1.push(S.charAt(i));
            } else {
                if (!s1.isEmpty()) {
                    s1.pop();   
                }
            }
        }
        
        for (int i=0; i<T.length(); i++) {
            if (T.charAt(i) != '#') {
                s2.push(T.charAt(i));
            } else {
                if (!s2.isEmpty()) {
                    s2.pop();   
                }
            }
        }
        
        if (s1.size() != s2.size()) {
            return false;
        }
        
        
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        
        while(!s1.isEmpty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }
        
        return true;
    }
    
}