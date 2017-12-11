class PalindromeCount{

    public static void main(String args[]){
        
    }

    static ArrayList subStrings(String s){
        ArrayList<String> list = new ArrayList<String>();
        
        for(int c = 0; c < s.length(); c++){
            
            for(int i = 1; i <= s.length() - c; i++){
                String sub = s.substring(c,c+i);
                list.add(sub);
            }
        }
        return list;
    }

    static boolean checkPalindrome(String s){
        if((new StringBuilder(s).reverse().toString()).equals(s)){
            return true;
        }
        return false;
    }

    static int count_palindromes(String S) {
        int count = 0;
        ArrayList<String> x = new ArrayList<String>();
        x = subStrings(S);
        
        
        for(int i=0; i<x.size(); i++){
            
            if(checkPalindrome(x.get(i))){
                System.out.println(x.get(i));
                count++;
            }
        }
        
        return count;
    }   
}

