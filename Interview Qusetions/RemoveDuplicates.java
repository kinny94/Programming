import java.util.*;

public class RemoveDuplicates{
    
    public static void removeDuplicates(String[] arr){
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }

        for(String s: set){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        int size = scan.nextInt();
        String[] s = new String[size];
        
        for(int i=0; i<size; i++){
            s[i] = scan.nextLine();
        }

        removeDuplicates(s);
    }    
}