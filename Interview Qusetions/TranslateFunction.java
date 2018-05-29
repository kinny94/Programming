import java.util.HashMap;
import java.util.*;

class TranslateFunction{
    
    public static String translate( String s ){
        String b = "123";
        String a = "abc";
        HashMap<Character, Character> map = new HashMap<Character, Character>();

        for( int i=0; i<a.length(); i ++ ){
            map.put( a.charAt( i ), b.charAt( i ) );
        }
        
        StringBuilder translatedString = new StringBuilder("");
        for( int i=0; i<s.length(); i++ ){
            if( map.containsKey( s.charAt( i ))){
                translatedString.append( map.get( s.charAt( i )).toString() );
            }
        }

        return translatedString.toString();
    }

    public static void main(String[] args) {
        
        String test = "aaabbbccc";
        System.out.println( translate( test ));
    }
}