import java.util.*;

class WordCount{
    
    public static void wordCounts( String sentence ){

        String[] arr = sentence.toLowerCase().replaceAll("[^a-zA-Z0-9]//s", "").split( " " );
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for( int i=0; i<arr.length; i++ ){
            if( map.containsKey( arr[i] )){
                map.put( arr[i], map.get( arr[i] ) + 1 );
            }else{  
                map.put( arr[i], 1 );
            }
        }

        Map<String, Integer> newMap = new TreeMap();
        newMap.putAll( map );

        System.out.println( newMap.toString() );
        Map.Entry<String, Integer> entry = newMap.entrySet().iterator().next();
        String key = entry.getKey();
        System.out.println( key );

    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        String sentence = scan.nextLine();
        wordCounts( sentence );
    }
}