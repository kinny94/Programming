import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

class PopularCharacter{
    
    public static String getPopularCharacter(String string){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String test = string.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
        String[] split = test.split(" ");
        
        for(int i=0; i<split.length; i++){
            if(map.containsKey(split[i])){
                map.put(split[i], map.get(split[i]) + 1);
            }else{
                map.put(split[i], 1);
            }
        }

        // sorting the hashmap
        Map<String, Integer> result2 = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        Map.Entry<String, Integer> entry = result2.entrySet().iterator().next();
        return entry.getKey();
        //System.out.println(Collections.singletonList(result2));
    }  

    public static void main(String[] args) {
        System.out.println("Enter a string...");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(getPopularCharacter(str));
    }
}