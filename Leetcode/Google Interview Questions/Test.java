// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;
class Test {
    
    public static ArrayList<String> permutation(String s){
        
        ArrayList<String> res = new ArrayList<String>();
        
        if(s.length() ==  1){
            res.add(s);    
        }else if( s.length() > 1){
            int lastIndex = s.length() - 1;
            String last = s.substring(lastIndex);
            String rest = s.substring(0, lastIndex);
            res = merge(permutation(rest), last);
        }
        
        Set<String> hs = new HashSet<>();
        hs.addAll(res);
        res.clear();
        res.addAll(hs);
        Collections.sort(res);
        return res;
    }
    
    public static ArrayList<String> merge(ArrayList<String> list, String c){
        ArrayList<String> res = new ArrayList<>();
        
        for(String s: list){
            for( int i=0; i<=s.length(); i++){
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }
    
    public String solution(String S) {
        String temp = S.replace("\"","").replace(":", "");
        StringBuilder string = new StringBuilder(temp);
        ArrayList<String> possibilities = permutation(string.toString());
        System.out.println(possibilities);
        if(possibilities.indexOf(string.toString()) == possibilities.size() - 1){
            
            StringBuilder finalString =  new StringBuilder(possibilities.get(0));
            finalString.insert(2, ':');
            return finalString.toString();
        }else{
            int index = possibilities.indexOf(string.toString());
            StringBuilder finalString =  new StringBuilder(possibilities.get(index + 1));
            finalString.insert(2, ':');
            return finalString.toString();
        }
    }

    public static void main(String[] args) {
        Test obj = new Test();
        System.out.println(obj.solution("00:11"));
    }
}