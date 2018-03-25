import java.util.ArrayList;
import java.util.*;

class DuplicateChar{

    public static ArrayList<String> duplicateChar( String input ){
        ArrayList<String> list = new ArrayList<String>();
        String newInput = input.replaceAll("[^a-zA-Z0-9]", "");
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for( int i=0; i<newInput.length(); i++ ){
            if( map.containsKey( String.valueOf( newInput.charAt( i )) )){
                map.put( String.valueOf( newInput.charAt( i )), map.get( String.valueOf( newInput.charAt( i )) ) + 1 );
            }else{
                map.put( String.valueOf( newInput.charAt( i )), 1 );
            }
        }

        for( Map.Entry<String, Integer> entry: map.entrySet()){
            if( entry.getValue() == 1 ){
                list.add( entry.getKey() );
            }
        }

        System.out.println( map.toString());
        return list;
    } 

    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        String input = scan.nextLine();
        System.out.println( duplicateChar(input).toString());
    }
}