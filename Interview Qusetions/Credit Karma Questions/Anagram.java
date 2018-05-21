import java.util.HashMap;
import java.util.Map;

class Anagram{
    
    public static boolean check( String a, String b ){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        if( a.length() != b.length() ){
            return false;
        }

        for( int i=0; i<a.length(); i++ ){
            if( map.containsKey( a.charAt(i))){
                map.put( a.charAt(i), map.get( a.charAt(i)) + 1 );
            }else{
                map.put( a.charAt(i), 1 );
            }
        }

        for( int i=0; i<a.length(); i++ ){
            if( map.containsKey( a.charAt(i))){
                map.put( a.charAt(i), map.get( a.charAt(i)) - 1 );
            }else{
                return false;
            }
        }

        for( Map.Entry<Character, Integer> entry: map.entrySet()){
            if( entry.getValue() != 0 ){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Anagram an = new Anagram();
        System.out.println( an.check("orchestra", "caarthorse") );
    }
}