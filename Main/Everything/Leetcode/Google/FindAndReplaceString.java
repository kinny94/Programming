import java.util.ArrayList;

class FindAndReplaceString {
    
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<indexes.length; i++) {
            if (S.startsWith(sources[i], indexes[i])) {
                map.put(indexes[i], i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<S.length();) {
            if (map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i+=sources[map.get(i)].length();
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        
        return sb.toString();
    }
}