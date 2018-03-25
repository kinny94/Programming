import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class UniqueWords{

    public static ArrayList<String> uniqueWordsfunc( String input ){
        String[] inputArray = input.split(" ");
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for( int i=0; i<inputArray.length; i++ ){
            String current = inputArray[i].replace("[^a-zA-Z0-9]", "");
            if( map.containsKey( current )){
                map.put( current, map.get( current ) + 1 );
            }else{
                map.put( current , 1 );
            }
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if( entry.getValue() == 1 ){
                list.add( entry.getKey() );
            }
        }
        
        return list;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println( uniqueWordsfunc( input ));
    }
}