import java.util.ArrayList;
import java.util.List;

class PermutationsOfAString {

    public List<String> permutationsOfAstring(String s) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        } 

        createPermutations(results, s, 0);
        return results;
    }

    private void createPermutations(List<String> results, String s, int currentIndex) {
        results.add(s);

        if (currentIndex == s.length() - 1) {
            return;
        }

        for (int i=0; i<s.length(); i++) {
            s = swap(s,currentIndex,i); 
            createPermutations(results, s, currentIndex+1); 
            s = swap(s,currentIndex, s.length() - 1); 
        }
    }
    
    public String swap(String a, int i, int j) { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 

    public static void main(String[] args) {
        String s = "abc";
        PermutationsOfAString obj = new PermutationsOfAString();
        System.out.println(obj.permutationsOfAstring(s));
    }
}