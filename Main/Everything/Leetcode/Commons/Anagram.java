import java.util.HashMap;
import java.util.Map;

class Anagram {

    public static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i=0; i<s2.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }

        for (int i=0; i<s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            } else {
                return false;
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Anagram ana = new Anagram();
        System.out.println(ana.isAnagram("Hello", "olleH"));
        System.out.println(ana.isAnagram("Hello", "olliH"));
        System.out.println(ana.isAnagram("nitIn", "ninit"));
    }
}