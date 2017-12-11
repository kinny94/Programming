import java.util.ArrayList;
import java.util.Collections;

class AllPossibleSubstring{

    public ArrayList<String> substrings(String x){
        ArrayList<String> substrings = new ArrayList<>();

        for(int i=0; i<x.length(); i++){
            for(int j=i+1; j<=x.length(); j++){
                substrings.add(x.substring(i, j));
            }
        }
        
        Collections.sort(substrings);
        Collections.reverse(substrings);
        return substrings;
    }

    public static void main(String[] args) {
        AllPossibleSubstring obj = new AllPossibleSubstring();
        System.out.println(obj.substrings("abcd").toString());
    }
}