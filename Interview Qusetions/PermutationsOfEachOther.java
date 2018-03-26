import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class PermutationsOfEachOther{
    
    public static boolean check( String string1, String string2 ){
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        if( string1.length() != string2.length()){
            return false;
        }

        for( int i=0; i<string1.length(); i++ ){
            if( map.containsKey( String.valueOf( string1.charAt(i)))){
                map.put( String.valueOf( string1.charAt(i)), map.get( String.valueOf( string1.charAt(i)) ) + 1 );
            }else{
                map.put( String.valueOf( string1.charAt(i)), 1 );
            }
        }

        for( int i=0; i<string2.length(); i++ ){
            if( map.containsKey( String.valueOf( string2.charAt(i)))){
                map.put( String.valueOf( string2.charAt(i)), map.get( String.valueOf( string2.charAt(i))) - 1);
            }else{
                return false;
            }
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if( entry.getValue() != 0 ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        System.out.println( check( str1, str2 ) );
    }
}