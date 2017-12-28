import  java.util.*;

public class UniqueCharacters{
    
    public static int uniqueCharacters(String string){
        String test = string.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
        String[] charArray = string.split(" ");
        HashSet<String> unique = new HashSet<>();
        for(int i =0; i<charArray.length; i++){
            unique.add(charArray[i]);
        }

        return unique.size();
    }  

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(uniqueCharacters(s));
    }
}