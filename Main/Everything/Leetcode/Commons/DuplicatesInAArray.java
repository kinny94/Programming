import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DuplicatesInAArray {
     
    public static List<Integer> findDuplicates(int a[]) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> duplicates = new ArrayList<Integer>();
        
        for (int i=0; i<a.length; i++) {
            if (map.containsKey(a[i])) {
                duplicates.add(a[i]);
            } else {
                map.put(a[i], 1);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 3, 3, 4, 5, 6, 6};
        DuplicatesInAArray dia = new DuplicatesInAArray(); 
        System.out.println(dia.findDuplicates(a));
    }
}