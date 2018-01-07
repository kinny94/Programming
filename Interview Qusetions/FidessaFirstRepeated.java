import java.util.*;
 
public class FidessaFirstRepeated
{
    // This function prints the first repeated
    // character in str[]
    static char firstRepeating(String str)
    {
        // Creates an empty hashset
        HashMap<Character, int[]> map = new HashMap<Character, int[]>();
 
        // Traverse the input array from left to right
        for (int i=0; i<str.length(); i++)
        {
            char c = str.charAt(i); 
            // If element is already in hash set, update x
            // and then break
            if (map.containsKey(c)){
                int temp[] = map.get(c);
                temp[0] = temp[0] + 1;
                map.put(c, temp);
            }
        
            else{
                int temp[] = new int[2];
                temp[0] = 1;
                temp[1] = i;
                map.put(c, temp);
            } // Else add element to hash set
                
        }

        System.out.println(map);
        int minIndex = Integer.MAX_VALUE;
        for(Map.Entry<Character, int[]> entry: map.entrySet()){
            if(entry.getValue()[0] >  1){
                int currentIndex = entry.getValue()[1];
                if(currentIndex < minIndex){
                    minIndex = currentIndex;
                }
            }
        }
 
        return str.charAt(minIndex);
    }
 
    // Driver method to test above method
    public static void main (String[] args)
    {
        String str = "abcba";
        System.out.println(firstRepeating(str));
    }
}